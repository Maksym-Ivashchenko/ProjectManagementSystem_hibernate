package ua.goit.homeworkhibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.SkillsDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class SkillsRepository implements Repository<SkillsDao> {
    private final HibernateProvider connector;

    public SkillsRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public SkillsDao save(SkillsDao entity) {
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
    public SkillsDao update(SkillsDao entity) {
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
    public void delete(SkillsDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SkillsDao findById(Integer id) {
        SkillsDao skillsDao = new SkillsDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            skillsDao = session.load(SkillsDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skillsDao;
    }

    @Override
    public List<SkillsDao> findAll() {
        List<SkillsDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;

    }

    private static List<SkillsDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SkillsDao> criteria = builder.createQuery(SkillsDao.class);
        criteria.from(SkillsDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
