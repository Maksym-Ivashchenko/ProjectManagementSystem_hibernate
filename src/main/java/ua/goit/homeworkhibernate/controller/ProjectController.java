package ua.goit.homeworkhibernate.controller;

import org.hibernate.mapping.Set;
import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dto.ProjectsDto;
import ua.goit.homeworkhibernate.repository.ProjectsRepository;
import ua.goit.homeworkhibernate.service.ProjectsService;
import ua.goit.homeworkhibernate.service.convert.ProjectsConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = "/projects/*")
public class ProjectController extends HttpServlet {
    private ProjectsService projectsService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        ProjectsRepository projectsRepository = new ProjectsRepository(dbProvider);
        ProjectsConverter projectsConverter = new ProjectsConverter();
        projectsService = new ProjectsService(projectsRepository, projectsConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<ProjectsDto> projects = projectsService.findAll();
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("/view/findAllProjects.jsp").forward(req, resp);
        } else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/find")) {
            try {
                int projectId = Integer.parseInt(req.getParameter("projectId"));
                ProjectsDto projectById = projectsService.findById(projectId);
                if (projectById.equals(new ProjectsDto())) {
                    String message = String.format("Project with ID %s not found", projectId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findProject.jsp").forward(req, resp);
                } else {
                    req.setAttribute("project", projectById);
                    req.getRequestDispatcher("/view/findProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findProject.jsp").forward(req, resp);
            }
        } else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/delete")) {
            doDelete(req, resp);
        } else if (action.matches("/format")) {
            List<String[]> listOfProjectsInTheFormat = projectsService.getListOfProjectsInTheFormat();
            req.setAttribute("projects", listOfProjectsInTheFormat);
            req.getRequestDispatcher("/view/getListOfProjectsInTheFormat.jsp").forward(req, resp);
            if (listOfProjectsInTheFormat.isEmpty()) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfProjectsInTheFormat.jsp").forward(req, resp);
            }
        } else if (action.matches("/salary/form")) {
            req.getRequestDispatcher("/view/salaryOfAllDevelopersFromProjectForm.jsp").forward(req, resp);
        } else if (action.matches("/salary")) {
            try {
                String projectName = req.getParameter("projectName");
                Integer salary = projectsService.getSalaryOfAllDevelopersFromProject(projectName);
                if (salary != 0) {
                    req.setAttribute("salary", salary);
                    req.getRequestDispatcher("/view/salaryOfAllDevelopersFromProject.jsp").forward(req, resp);
                } else {
                    String message = "Wrong enter. Try again";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/salaryOfAllDevelopersFromProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/salaryOfAllDevelopersFromProject.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            try {
                String projectName = req.getParameter("projectName");
                String projectType = req.getParameter("projectType");
                String comments = req.getParameter("comments");
                int cost = Integer.parseInt(req.getParameter("cost"));
                LocalDate dateCreated = LocalDate.parse(req.getParameter("dateCreated"));
                ProjectsDto project = new ProjectsDto(projectName, projectType, comments, cost, dateCreated);
                if (!project.getProjectName().isBlank() || !project.getProjectType().isBlank()
                        || !project.getComments().isBlank() || Objects.isNull(project.getDateCreated())) {
                    ProjectsDto savedProject = projectsService.save(project);
                    req.setAttribute("savedProject", savedProject);
                    req.setAttribute("message", "Project added");
                    req.getRequestDispatcher("/view/addProject.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Project not added");
                    req.getRequestDispatcher("/view/addProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/addProject.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int projectId = Integer.parseInt(req.getParameter("projectId"));
                String projectName = req.getParameter("projectName");
                String projectType = req.getParameter("projectType");
                String comments = req.getParameter("comments");
                int cost = Integer.parseInt(req.getParameter("cost"));
                LocalDate dateCreated = LocalDate.parse(req.getParameter("dateCreated"));
                ProjectsDto project = new ProjectsDto(projectId, projectName, projectType, comments, cost, dateCreated);
                if (!project.getProjectName().isBlank() || !project.getProjectType().isBlank()
                        || !project.getComments().isBlank()) {
                    ProjectsDto updatedProject = projectsService.update(project);
                    req.setAttribute("updatedProject", updatedProject);
                    req.setAttribute("message", "Project updated");
                    req.getRequestDispatcher("/view/updateProject.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Project not updated");
                    req.getRequestDispatcher("/view/updateProject.jsp").forward(req, resp);
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateProject.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int projectId = Integer.parseInt(req.getParameter("projectId"));
            ProjectsDto project = projectsService.findById(projectId);
            String message;
            if (project.equals(new ProjectsDto())) {
                message = String.format("Project with ID %s not found", projectId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteProject.jsp").forward(req, resp);
            } else {
                message = String.format("Project with ID %s deleted", projectId);
                req.setAttribute("developer", project);
                req.setAttribute("message", message);
                projectsService.delete(project);
                req.getRequestDispatcher("/view/deleteProject.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteProject.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
