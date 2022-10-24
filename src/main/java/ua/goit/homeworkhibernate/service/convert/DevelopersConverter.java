package ua.goit.homeworkhibernate.service.convert;

import ua.goit.homeworkhibernate.model.dao.DevelopersDao;
import ua.goit.homeworkhibernate.model.dto.DevelopersDto;

public class DevelopersConverter implements Converter<DevelopersDto, DevelopersDao> {
    @Override
    public DevelopersDto from(DevelopersDao entity) {
        DevelopersDto dto = new DevelopersDto();
        dto.setId(entity.getId());
        dto.setDeveloperName(entity.getDeveloperName());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setDifferent(entity.getDifferent());
        dto.setSalary(entity.getSalary());
        return dto;
    }

    @Override
    public DevelopersDao to(DevelopersDto entity) {
        DevelopersDao dao = new DevelopersDao();
        dao.setId(entity.getId());
        dao.setDeveloperName(entity.getDeveloperName());
        dao.setAge(entity.getAge());
        dao.setGender(entity.getGender());
        dao.setDifferent(entity.getDifferent());
        dao.setSalary(entity.getSalary());
        return dao;
    }
}
