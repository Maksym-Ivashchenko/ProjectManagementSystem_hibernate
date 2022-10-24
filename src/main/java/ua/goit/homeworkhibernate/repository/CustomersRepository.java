package ua.goit.homeworkhibernate.repository;

import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.CustomersDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomersRepository implements Repository<CustomersDao> {
    private final HibernateProvider connector;
    private static final String INSERT = "INSERT INTO customers (customer_name, country, email) " +
            "VALUES (?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, customer_name, country, email " +
            "FROM customers WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE customers " +
            "SET customer_name = ?, country = ?, email = ?" +
            "WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM customers WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, customer_name, country, email " +
            "FROM customers;";

    public CustomersRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public CustomersDao save(CustomersDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
//
//            statement.setString(1, entity.getCustomerName());
//            statement.setString(2, entity.getCountry());
//            statement.setString(3, entity.getEmail());
//
//            statement.executeUpdate();
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    entity.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Creating customer failed, no ID obtained.");
//                }
//            }
//
//        } catch (
//                SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Customer is not created");
//        }
//        return entity;
        return null;
    }

    @Override
    public CustomersDao update(CustomersDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
//
//            statement.setString(1, entity.getCustomerName());
//            statement.setString(2, entity.getCountry());
//            statement.setString(3, entity.getEmail());
//            statement.setInt(4, entity.getId());
//
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Customer is not updated");
//        }
//        return entity;
        return null;
    }

    @Override
    public void delete(CustomersDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
//            statement.setInt(1, entity.getId());
//
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Customer is not deleted");
//        }
    }

    @Override
    public CustomersDao findById(Integer id) {
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
//
//            statement.setInt(1, id);
//
//            resultSet = statement.executeQuery();
//            return Objects.isNull(resultSet) ? new CustomersDao() : convert(resultSet);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return new CustomersDao();
    }

    @Override
    public List<CustomersDao> findAll() {
//        List<CustomersDao> daoList = new ArrayList<>();
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
//
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                CustomersDao customersDao = new CustomersDao();
//                setParameters(resultSet, customersDao);
//                daoList.add(customersDao);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Customers not found");
//        }
//        return daoList;
        return null;
    }

    private CustomersDao convert(ResultSet resultSet) throws SQLException {
        CustomersDao customersDao = new CustomersDao();
        while (resultSet.next()) {
            setParameters(resultSet, customersDao);
        }
        return customersDao;
    }

    private void setParameters(ResultSet resultSet, CustomersDao customersDao) throws SQLException {
        customersDao.setId(resultSet.getInt("id"));
        customersDao.setCustomerName(resultSet.getString("customer_name"));
        customersDao.setCountry(resultSet.getString("country"));
        customersDao.setEmail(resultSet.getString("email"));
    }
}
