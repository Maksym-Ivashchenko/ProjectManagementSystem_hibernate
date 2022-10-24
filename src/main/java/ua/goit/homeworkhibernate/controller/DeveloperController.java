package ua.goit.homeworkhibernate.controller;

import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dto.DevelopersDto;
import ua.goit.homeworkhibernate.repository.DevelopersRepository;
import ua.goit.homeworkhibernate.service.DevelopersService;
import ua.goit.homeworkhibernate.service.convert.DevelopersConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/developers/*")
public class DeveloperController extends HttpServlet {
    private DevelopersService developersService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        DevelopersRepository developersRepository = new DevelopersRepository(dbProvider);
        DevelopersConverter developersConverter = new DevelopersConverter();
        developersService = new DevelopersService(developersRepository, developersConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<DevelopersDto> developers = developersService.findAll();
            req.setAttribute("developers", developers);
            req.getRequestDispatcher("/view/findAllDevelopers.jsp").forward(req, resp);
        } else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/find")) {
            try {
                int developerId = Integer.parseInt(req.getParameter("developerId"));
                DevelopersDto developerById = developersService.findById(developerId);
                if (developerById.equals(new DevelopersDto())) {
                    String message = String.format("Developer with ID %s not found", developerId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findDeveloper.jsp").forward(req, resp);
                } else {
                    req.setAttribute("developer", developerById);
                    req.getRequestDispatcher("/view/findDeveloper.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findDeveloper.jsp").forward(req, resp);
            }
        } else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteDeveloperForm.jsp").forward(req, resp);
        } else if (action.matches("/delete")) {
            doDelete(req, resp);
        } else if (action.matches("/branch/form")) {
            req.getRequestDispatcher("/view/getListOfAllDevelopersByBranchForm.jsp").forward(req, resp);
        } else if (action.matches("/branch")) {
            String developerBranch = req.getParameter("developerBranch");
            List<DevelopersDto> developersByBranch = developersService.getListOfAllDevelopersByBranch(developerBranch);
            if (!developersByBranch.isEmpty()) {
                req.setAttribute("developers", developersByBranch);
                String message = "Developers found";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfAllDevelopersByBranch.jsp").forward(req, resp);
            } else {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfAllDevelopersByBranch.jsp").forward(req, resp);
            }
        } else if (action.matches("/level/form")) {
            req.getRequestDispatcher("/view/getListOfAllDevelopersBySkillLevelForm.jsp").forward(req, resp);
        } else if (action.matches("/level")) {
            String skillLevel = req.getParameter("developerSkillLevel");
            List<DevelopersDto> developersBySkillLevel = developersService.getListOfAllDevelopersBySkillLevel(skillLevel);
            if (!developersBySkillLevel.isEmpty()) {
                req.setAttribute("developers", developersBySkillLevel);
                String message = "Developers found";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfAllDevelopersBySkillLevel.jsp").forward(req, resp);
            } else {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfAllDevelopersBySkillLevel.jsp").forward(req, resp);
            }
        } else if (action.matches("/project/form")) {
            req.getRequestDispatcher("/view/getListOfProjectDevelopersForm.jsp").forward(req, resp);
        } else if (action.matches("/project")) {
            String projectName = req.getParameter("projectName");
            List<DevelopersDto> listOfProjectDevelopers = developersService.getListOfProjectDevelopers(projectName);
            if (!listOfProjectDevelopers.isEmpty()) {
                req.setAttribute("developers", listOfProjectDevelopers);
                String message = "Developers found";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfProjectDevelopers.jsp").forward(req, resp);
            } else {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/getListOfProjectDevelopers.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            try {
                String developerName = req.getParameter("developerName");
                int age = Integer.parseInt(req.getParameter("age"));
                String gender = req.getParameter("gender");
                String different = req.getParameter("different");
                int salary = Integer.parseInt(req.getParameter("salary"));
                DevelopersDto developer = new DevelopersDto(developerName, age, gender, different, salary);
                if (!developer.getDeveloperName().isBlank() || !developer.getGender().isBlank()
                        || !developer.getDifferent().isBlank()) {
                    DevelopersDto savedDeveloper = developersService.save(developer);
                    req.setAttribute("savedDeveloper", savedDeveloper);
                    req.setAttribute("message", "Developer added");
                    req.getRequestDispatcher("/view/addDeveloper.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Developer not added");
                    req.getRequestDispatcher("/view/addDeveloper.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/addDeveloper.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int developerId = Integer.parseInt(req.getParameter("developerId"));
                String developerName = req.getParameter("developerName");
                int age = Integer.parseInt(req.getParameter("age"));
                String gender = req.getParameter("gender");
                String different = req.getParameter("different");
                int salary = Integer.parseInt(req.getParameter("salary"));
                DevelopersDto developer = new DevelopersDto(developerId, developerName, age, gender, different, salary);
                if (!developer.getDeveloperName().isBlank() || !developer.getGender().isBlank()
                        || !developer.getDifferent().isBlank()) {
                    DevelopersDto updatedDeveloper = developersService.update(developer);
                    req.setAttribute("updatedDeveloper", updatedDeveloper);
                    req.setAttribute("message", "Developer updated");
                    req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Developer not updated");
                    req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateDeveloper.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int developerId = Integer.parseInt(req.getParameter("developerId"));
            DevelopersDto developer = developersService.findById(developerId);
            String message;
            if (developer.equals(new DevelopersDto())) {
                message = String.format("Developer with ID %s not found", developerId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
            } else {
                message = String.format("Developer with ID %s deleted", developerId);
                req.setAttribute("developer", developer);
                req.setAttribute("message", message);
                developersService.delete(developer);
                req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteDeveloper.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
