package ua.goit.homeworkhibernate.service.convert;

import ua.goit.homeworkhibernate.model.dao.CompaniesDao;
import ua.goit.homeworkhibernate.model.dto.CompaniesDto;

public class CompaniesConverter implements Converter<CompaniesDto, CompaniesDao> {
    @Override
    public CompaniesDto from(CompaniesDao entity) {
        CompaniesDto dto = new CompaniesDto();
        dto.setId(entity.getId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setCity(entity.getCity());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    public CompaniesDao to(CompaniesDto entity) {
        CompaniesDao dao = new CompaniesDao();
        dao.setId(entity.getId());
        dao.setCompanyName(entity.getCompanyName());
        dao.setCity(entity.getCity());
        dao.setEmail(entity.getEmail());
        return dao;
    }
}
