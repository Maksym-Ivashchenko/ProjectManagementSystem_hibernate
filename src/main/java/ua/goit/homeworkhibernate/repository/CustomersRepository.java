package ua.goit.homeworkhibernate.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.CustomersDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class CustomersRepository implements Repository<CustomersDao> {
    private final HibernateProvider connector;

    public CustomersRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public CustomersDao save(CustomersDao entity) {
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
    public CustomersDao update(CustomersDao entity) {
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
    public void delete(CustomersDao entity) {
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomersDao findById(Integer id) {
        CustomersDao customersDao = new CustomersDao();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            customersDao = session.load(CustomersDao.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customersDao;
    }

    @Override
    public List<CustomersDao> findAll() {
        List<CustomersDao> daoList = new ArrayList<>();
        try(Session session = connector.openSession()) {
            Transaction transaction = session.beginTransaction();
            daoList = loadAllData(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daoList;
    }

    private static List<CustomersDao> loadAllData(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CustomersDao> criteria = builder.createQuery(CustomersDao.class);
        criteria.from(CustomersDao.class);
        return session.createQuery(criteria).getResultList();
    }
}
