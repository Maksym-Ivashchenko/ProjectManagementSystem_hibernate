package ua.goit.homeworkhibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.DevelopersDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DevelopersRepository implements Repository<DevelopersDao> {
    private final HibernateProvider connector;
    private static final String INSERT = "INSERT INTO developers (developer_name, age, gender, " +
            "different, salary) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "SELECT id, developer_name, age, gender, different, salary" +
            " FROM developers WHERE id = ?;";
    private static final String UPDATE_BY_ID = "UPDATE developers" +
            " SET developer_name = ?, age = ?, gender = ?, different = ?, salary = ?" +
            " WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM developers WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, developer_name, age, gender, different, salary " +
            "FROM developers;";
    private static final String LIST_OF_ALL_DEVELOPERS_BY_BRANCH =
            "SELECT d.id, d.developer_name, d.age, d.gender, d.different, d.salary FROM developers AS d" +
                    " JOIN developers_skills AS ds ON d.id = ds.developer_id" +
                    " JOIN skills AS s ON s.id = ds.skill_id" +
                    " WHERE s.branch = ?;";
    private static final String LIST_OF_ALL_DEVELOPERS_BY_SKILL_LEVEL =
            "SELECT d.id, d.developer_name, d.age, d.gender, d.different, d.salary FROM developers AS d" +
                    " JOIN developers_skills AS ds ON d.id = ds.developer_id" +
                    " JOIN skills AS s ON s.id = ds.skill_id" +
                    " WHERE s.skill_level = ?;";
    private static final String LIST_OF_PROJECT_DEVELOPERS =
            "SELECT d.id, d.developer_name, d.age, d.gender, d.different, d.salary FROM developers AS d" +
                    " JOIN developers_projects AS dp ON d.id = dp.developer_id" +
                    " JOIN projects AS p ON p.id = dp.project_id" +
                    " WHERE p.project_name = ?;";

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
            daoList = loadAllData(DevelopersDao.class, session);
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

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }
}
