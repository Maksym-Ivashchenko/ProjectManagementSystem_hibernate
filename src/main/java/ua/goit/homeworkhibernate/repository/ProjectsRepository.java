package ua.goit.homeworkhibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.ProjectsDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class ProjectsRepository implements Repository<ProjectsDao> {
    private final HibernateProvider connector;

    public ProjectsRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public ProjectsDao save(ProjectsDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public ProjectsDao update(ProjectsDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void delete(ProjectsDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProjectsDao findById(Integer id) {
        ProjectsDao projectsDao = new ProjectsDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            projectsDao = session.load(ProjectsDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectsDao;
    }

    @Override
    public List<ProjectsDao> findAll() {
        List<ProjectsDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    public Integer getSalaryOfAllDevelopersFromProject(String projectName) {
        int sumSalary = -1;
        try(Session session = connector.openSession()) {
            sumSalary = session
                    .createQuery("SELECT d.salary FROM DevelopersDao d INNER JOIN d.projects p" +
                            " WHERE p.projectName = :projectName", Integer.class)
                    .setParameter("projectName", projectName)
                    .stream().mapToInt(Integer::intValue).sum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sumSalary;
    }

    public List<String[]> getListOfProjectsInTheFormat() {
        List<String[]> resultList = new ArrayList<>();

        try(Session session = connector.openSession()) {
            resultList = session
                    .createQuery("SELECT p.dateCreated, p.projectName, COUNT(d.developerName)" +
                            " FROM ProjectsDao p INNER JOIN p.developers d GROUP BY p.dateCreated, p.projectName" +
                            " ORDER BY p.projectName", String[].class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private static List<ProjectsDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProjectsDao> criteria = builder.createQuery(ProjectsDao.class);
        criteria.from(ProjectsDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
