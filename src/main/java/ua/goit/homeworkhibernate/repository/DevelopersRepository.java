package ua.goit.homeworkhibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.DevelopersDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class DevelopersRepository implements Repository<DevelopersDao> {
    private final HibernateProvider connector;

    public DevelopersRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public DevelopersDao save(DevelopersDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public DevelopersDao update(DevelopersDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public void delete(DevelopersDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }
    }

    @Override
    public DevelopersDao findById(Integer id) {
        DevelopersDao developersDao = new DevelopersDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            developersDao = session.load(DevelopersDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developersDao;
    }

    @Override
    public List<DevelopersDao> findAll() {
        List<DevelopersDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    public List<DevelopersDao> getListOfAllDevelopersByBranch(String branch) {
        List<DevelopersDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            return daoList = session
                    .createQuery("SELECT d FROM DevelopersDao d INNER JOIN d.skills s WHERE s.branch = :branch",
                            DevelopersDao.class)
                    .setParameter("branch", branch)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    public List<DevelopersDao> getListOfAllDevelopersBySkillLevel(String skillLevel) {
        List<DevelopersDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            return daoList = session
                    .createQuery("SELECT d FROM DevelopersDao d INNER JOIN d.skills s" +
                            " WHERE s.skillLevel = :skillLevel", DevelopersDao.class)
                    .setParameter("skillLevel", skillLevel)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    public List<DevelopersDao> getListOfProjectDevelopers(String projectName) {
        List<DevelopersDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            return daoList = session
                    .createQuery("SELECT d FROM DevelopersDao d INNER JOIN d.projects p" +
                            " WHERE p.projectName = :projectName", DevelopersDao.class)
                    .setParameter("projectName", projectName)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<DevelopersDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DevelopersDao> criteria = builder.createQuery(DevelopersDao.class);
        criteria.from(DevelopersDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
