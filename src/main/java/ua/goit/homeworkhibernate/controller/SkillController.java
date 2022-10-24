package ua.goit.homeworkhibernate.controller;

import ua.goit.homeworkhibernate.config.HibernateProvider;
import ua.goit.homeworkhibernate.model.dto.SkillsDto;
import ua.goit.homeworkhibernate.repository.SkillsRepository;
import ua.goit.homeworkhibernate.service.SkillsService;
import ua.goit.homeworkhibernate.service.convert.SkillsConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/skills/*")
public class SkillController extends HttpServlet {
    private SkillsService skillsService;

    @Override
    public void init() {
        HibernateProvider dbProvider = new HibernateProvider();
        SkillsRepository skillsRepository = new SkillsRepository(dbProvider);
        SkillsConverter skillsConverter = new SkillsConverter();
        skillsService = new SkillsService(skillsRepository, skillsConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/all")) {
            List<SkillsDto> skills = skillsService.findAll();
            req.setAttribute("skills", skills);
            req.getRequestDispatcher("/view/findAllSkills.jsp").forward(req, resp);
        }
        else if (action.matches("/form")) {
            req.getRequestDispatcher("/view/findSkillForm.jsp").forward(req, resp);
        }
        else if (action.matches("/find")) {
            try {
                int skillId = Integer.parseInt(req.getParameter("skillId"));
                SkillsDto skillById = skillsService.findById(skillId);
                if (skillById.equals(new SkillsDto())) {
                    String message = String.format("Skill with ID %s not found", skillId);
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
                } else {
                    req.setAttribute("skill", skillById);
                    req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/findSkill.jsp").forward(req, resp);
            }
        }
        else if (action.matches("/add")) {
            req.getRequestDispatcher("/view/addSkillForm.jsp").forward(req, resp);
        }
        else if (action.matches("/update/form")) {
            req.getRequestDispatcher("/view/updateSkillForm.jsp").forward(req, resp);
        }
        else if (action.matches("/delete/form")) {
            req.getRequestDispatcher("/view/deleteSkillForm.jsp").forward(req, resp);
        }
        else if (action.startsWith("/delete")) {
            doDelete(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = getAction(req);

        if (action.matches("/add")) {
            String branch = req.getParameter("branch");
            String skillLevel = req.getParameter("skillLevel");
            SkillsDto skills = new SkillsDto(branch, skillLevel);
            if (!skills.getBranch().isBlank() || !skills.getSkillLevel().isBlank()) {
                SkillsDto savedSkill = skillsService.save(skills);
                req.setAttribute("savedSkill", savedSkill);
                req.setAttribute("message", "Skill added");
                req.getRequestDispatcher("/view/addSkill.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Skill not added");
                req.getRequestDispatcher("/view/addSkill.jsp").forward(req, resp);
            }
        } else if (action.matches("/update")) {
            try {
                int skillId = Integer.parseInt(req.getParameter("skillId"));
                String branch = req.getParameter("branch");
                String skillLevel = req.getParameter("skillLevel");
                SkillsDto skills = new SkillsDto(skillId, branch, skillLevel);
                if (!skills.getBranch().isBlank() || !skills.getSkillLevel().isBlank()) {
                    SkillsDto updatedSkill = skillsService.update(skills);
                    req.setAttribute("updatedSkill", updatedSkill);
                    req.setAttribute("message", "Skill updated");
                    req.getRequestDispatcher("/view/updateSkill.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Skill not updated");
                    req.getRequestDispatcher("/view/updateSkill.jsp").forward(req, resp);
                }
            } catch (NumberFormatException e) {
                String message = "Wrong enter. Try again";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/updateSkill.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int skillId = Integer.parseInt(req.getParameter("skillId"));
            SkillsDto skill = skillsService.findById(skillId);
            String message;
            if (skill.equals(new SkillsDto())) {
                message = String.format("Skill with ID %s not found", skillId);
                req.setAttribute("message", message);
                req.getRequestDispatcher("/view/deleteSkill.jsp").forward(req, resp);
            } else {
                message = String.format("Skill with ID %s deleted", skillId);
                req.setAttribute("skill", skill);
                req.setAttribute("message", message);
                skillsService.delete(skill);
                req.getRequestDispatcher("/view/deleteSkill.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            String message = "Wrong enter. Try again";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/view/deleteSkill.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String requestPathWithServletContext = req.getContextPath() + req.getServletPath();
        return requestURI.substring(requestPathWithServletContext.length());
    }
}
