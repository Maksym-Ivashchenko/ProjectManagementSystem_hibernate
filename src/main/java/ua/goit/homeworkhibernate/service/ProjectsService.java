package ua.goit.homeworkhibernate.service;

import ua.goit.homeworkhibernate.model.dao.ProjectsDao;
import ua.goit.homeworkhibernate.model.dto.ProjectsDto;
import ua.goit.homeworkhibernate.repository.ProjectsRepository;
import ua.goit.homeworkhibernate.service.convert.ProjectsConverter;

import java.util.ArrayList;
import java.util.List;

public class ProjectsService implements Service<ProjectsDto> {
    private final ProjectsRepository projectsRepository;
    private final ProjectsConverter projectsConverter;

    public ProjectsService(ProjectsRepository projectsRepository, ProjectsConverter projectsConverter) {
        this.projectsRepository = projectsRepository;
        this.projectsConverter = projectsConverter;
    }

    @Override
    public ProjectsDto save(ProjectsDto dto) {
        ProjectsDao savedProject = projectsRepository.save(projectsConverter.to(dto));
        return projectsConverter.from(savedProject);
    }

    @Override
    public ProjectsDto update(ProjectsDto dto) {
        ProjectsDao project = projectsRepository.update(projectsConverter.to(dto));
        return projectsConverter.from(project);
    }

    @Override
    public void delete(ProjectsDto dto) {
        projectsRepository.delete(projectsConverter.to(dto));
    }

    @Override
    public ProjectsDto findById(Integer id) {
        ProjectsDao byId = projectsRepository.findById(id);
        return projectsConverter.from(byId);
    }

    @Override
    public List<ProjectsDto> findAll() {
        List<ProjectsDto> projectsDtoList = new ArrayList<>();
        List<ProjectsDao> projectsDaoList = projectsRepository.findAll();
        for (ProjectsDao dao: projectsDaoList) {
            projectsDtoList.add(projectsConverter.from(dao));
        }
        return projectsDtoList;
    }

    public Integer getSalaryOfAllDevelopersFromProject(String projectName) {
        return projectsRepository.getSalaryOfAllDevelopersFromProject(projectName);
    }

    public List<List<String>> getListOfProjectsInTheFormat() {
        return projectsRepository.getListOfProjectsInTheFormat();
    }
}
