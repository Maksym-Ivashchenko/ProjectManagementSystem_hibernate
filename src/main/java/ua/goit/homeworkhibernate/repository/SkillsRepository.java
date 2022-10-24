package ua.goit.homeworkhibernate.repository;

import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.SkillsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SkillsRepository implements Repository<SkillsDao> {
    private final HibernateProvider connector;
    private static final String INSERT = "INSERT INTO skills (branch, skill_level) " +
            "VALUES (?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, branch, skill_level " +
            "FROM skills WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE skills " +
            "SET branch = ?, skill_level = ? WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM skills WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, branch, skill_level FROM skills;";


    public SkillsRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public SkillsDao save(SkillsDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
//
//            statement.setString(1, entity.getBranch());
//            statement.setString(2, entity.getSkillLevel());
//
//            statement.executeUpdate();
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    entity.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Creating skill failed, no ID obtained.");
//                }
//            }
//        } catch (
//                SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Skill is not created");
//        }
//        return entity;
        return null;
    }

    @Override
    public SkillsDao update(SkillsDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
//
//            statement.setString(1, entity.getBranch());
//            statement.setString(2, entity.getSkillLevel());
//            statement.setInt(3, entity.getId());
//
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Skill is not updated");
//        }
//        return entity;
        return null;
    }

    @Override
    public void delete(SkillsDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
//            statement.setInt(1, entity.getId());
//
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Skill is not deleted");
//        }
    }

    @Override
    public SkillsDao findById(Integer id) {
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
//
//            statement.setInt(1, id);
//
//            resultSet = statement.executeQuery();
//            return Objects.isNull(resultSet) ? new SkillsDao() : convert(resultSet);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return new SkillsDao();
    }

    @Override
    public List<SkillsDao> findAll() {
//        List<SkillsDao> daoList = new ArrayList<>();
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
//
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                SkillsDao skillsDao = new SkillsDao();
//                skillsDao.setId(resultSet.getInt("id"));
//                skillsDao.setBranch(resultSet.getString("branch"));
//                skillsDao.setSkillLevel(resultSet.getString("skill_level"));
//                daoList.add(skillsDao);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Skills not found");
//        }
//        return daoList;
        return null;
    }

    private SkillsDao convert(ResultSet resultSet) throws SQLException {
        SkillsDao skillsDao = new SkillsDao();
        while (resultSet.next()) {
            skillsDao.setId(resultSet.getInt("id"));
            skillsDao.setBranch(resultSet.getString("branch"));
            skillsDao.setSkillLevel(resultSet.getString("skill_level"));
        }
        return skillsDao;
    }
}
