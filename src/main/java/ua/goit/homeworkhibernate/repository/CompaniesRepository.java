package ua.goit.homeworkhibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.CompaniesDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CompaniesRepository implements Repository<CompaniesDao> {
    HibernateProvider connector;

    public CompaniesRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public CompaniesDao save(CompaniesDao entity) {
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
    public CompaniesDao update(CompaniesDao entity) {
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
    public void delete(CompaniesDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CompaniesDao findById(Integer id) {
        CompaniesDao companiesDao = new CompaniesDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            companiesDao = session.load(CompaniesDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companiesDao;
    }

    @Override
    public List<CompaniesDao> findAll() {
        List<CompaniesDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<CompaniesDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CompaniesDao> criteria = builder.createQuery(CompaniesDao.class);
        criteria.from(CompaniesDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
