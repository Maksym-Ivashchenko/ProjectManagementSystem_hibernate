package ua.goit.homeworkhibernate.service.convert;

import ua.goit.homeworkhibernate.model.dao.ProjectsDao;
import ua.goit.homeworkhibernate.model.dto.ProjectsDto;

public class ProjectsConverter implements Converter<ProjectsDto, ProjectsDao> {
    @Override
    public ProjectsDto from(ProjectsDao entity) {
        ProjectsDto dto = new ProjectsDto();
        dto.setId(entity.getId());
        dto.setProjectName(entity.getProjectName());
        dto.setProjectType(entity.getProjectType());
        dto.setComments(entity.getComments());
        dto.setCost(entity.getCost());
        dto.setDateCreated(entity.getDateCreated());
        return dto;
    }

    @Override
    public ProjectsDao to(ProjectsDto entity) {
        ProjectsDao dao = new ProjectsDao();
        dao.setId(entity.getId());
        dao.setProjectName(entity.getProjectName());
        dao.setProjectType(entity.getProjectType());
        dao.setComments(entity.getComments());
        dao.setCost(entity.getCost());
        dao.setDateCreated(entity.getDateCreated());
        return dao;
    }
}
