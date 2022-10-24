package ua.goit.homeworkhibernate.repository;

import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dao.ProjectsDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectsRepository implements Repository<ProjectsDao> {
    private final HibernateProvider connector;
    private static final String INSERT = "INSERT INTO projects (project_name, project_type, " +
            "comments, cost, date_created) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id, project_name, project_type, comments, cost, date_created " +
            "FROM projects WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE projects " +
            "SET project_name = ?, project_type = ?, comments = ?, cost = ?, date_created = ?" +
            " WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM projects WHERE id = ?;";
    private static final String SELECT_ALL = "SELECT id, project_name, project_type, comments, cost, date_created " +
            "FROM projects;";
    private static final String SALARY_OF_ALL_DEVELOPERS = "SELECT sum(d.salary) FROM developers AS d" +
            " JOIN developers_projects AS dp ON d.id = dp.developer_id" +
            " JOIN projects AS p ON p.id = dp.project_id" +
            " WHERE p.project_name = ?;";
    private static final String LIST_OF_PROJECTS_IN_THE_FORMAT =
            "SELECT p.date_created, p.project_name, COUNT(d.developer_name) FROM projects AS p" +
            " JOIN developers_projects AS dp ON p.id = dp.project_id" +
            " JOIN developers AS d ON d.id = dp.developer_id" +
            " GROUP BY p.date_created, p.project_name" +
            " ORDER BY p.project_name;";

    public ProjectsRepository(HibernateProvider connector) {
        this.connector = connector;
    }

    @Override
    public ProjectsDao save(ProjectsDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
//
//            statement.setString(1, entity.getProjectName());
//            statement.setString(2, entity.getProjectType());
//            statement.setString(3, entity.getComments());
//            statement.setInt(4, entity.getCost());
//            statement.setDate(5, Date.valueOf(entity.getDateCreated()));
//            statement.executeUpdate();
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    entity.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Creating project failed, no ID obtained.");
//                }
//            }
//        } catch (
//                SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Project is not created");
//        }
//        return entity;
        return null;
    }

    @Override
    public ProjectsDao update(ProjectsDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)) {
//            statement.setString(1, entity.getProjectName());
//            statement.setString(2, entity.getProjectType());
//            statement.setString(3, entity.getComments());
//            statement.setInt(4, entity.getCost());
//            statement.setDate(5, Date.valueOf(entity.getDateCreated()));
//            statement.setInt(6, entity.getId());
//
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Project is not updated");
//        }
//        return entity;
        return null;
    }

    @Override
    public void delete(ProjectsDao entity) {
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
//            statement.setInt(1, entity.getId());
//
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Project is not deleted");
//        }
    }

    @Override
    public ProjectsDao findById(Integer id) {
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
//
//            statement.setInt(1, id);
//
//            resultSet = statement.executeQuery();
//            return Objects.isNull(resultSet) ? new ProjectsDao() : convert(resultSet);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return new ProjectsDao();
    }

    @Override
    public List<ProjectsDao> findAll() {
//        List<ProjectsDao> daoList = new ArrayList<>();
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
//
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                ProjectsDao projectsDao = new ProjectsDao();
//                setParameters(resultSet, projectsDao);
//                daoList.add(projectsDao);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Projects not found");
//        }
//        return daoList;
        return null;
    }

    public Integer getSalaryOfAllDevelopersFromProject(String projectName) {
//        ResultSet resultSet;
//        int result = 0;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SALARY_OF_ALL_DEVELOPERS)) {
//            statement.setString(1, projectName);
//
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                result = resultSet.getInt(1);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Request failed!");
//        }
//        return result;
        return null;
    }

    public List<List<String>> getListOfProjectsInTheFormat() {
//        List<List<String>> results = new ArrayList<>();
//        ResultSet resultSet;
//        try (Connection connection = connector.getConnection();
//             PreparedStatement statement = connection.prepareStatement(LIST_OF_PROJECTS_IN_THE_FORMAT)) {
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                List<String> daoList = new ArrayList<>();
//                daoList.add(resultSet.getString("date_created"));
//                daoList.add(resultSet.getString("project_name"));
//                daoList.add(resultSet.getString("count"));
//                results.add(daoList);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Request failed!");
//        }
//        return results;
        return null;
    }

    private ProjectsDao convert(ResultSet resultSet) throws SQLException {
        ProjectsDao projectsDao = new ProjectsDao();
        while (resultSet.next()) {
            setParameters(resultSet, projectsDao);
        }
        return projectsDao;
    }

    private void setParameters(ResultSet resultSet, ProjectsDao projectsDao) throws SQLException {
        projectsDao.setId(resultSet.getInt("id"));
        projectsDao.setProjectName(resultSet.getString("project_name"));
        projectsDao.setProjectType(resultSet.getString("project_type"));
        projectsDao.setComments(resultSet.getString("comments"));
        projectsDao.setCost(resultSet.getInt("cost"));
        projectsDao.setDateCreated(resultSet.getDate("date_created").toLocalDate());
    }
}
