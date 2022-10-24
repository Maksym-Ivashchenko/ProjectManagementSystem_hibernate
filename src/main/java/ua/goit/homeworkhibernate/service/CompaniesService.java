package ua.goit.homeworkhibernate.service;

import ua.goit.homeworkhibernate.model.dao.CompaniesDao;
import ua.goit.homeworkhibernate.model.dto.CompaniesDto;
import ua.goit.homeworkhibernate.repository.CompaniesRepository;
import ua.goit.homeworkhibernate.service.convert.CompaniesConverter;

import java.util.ArrayList;
import java.util.List;

public class CompaniesService implements Service<CompaniesDto> {
    private final CompaniesRepository companiesRepository;
    private final CompaniesConverter companiesConverter;

    public CompaniesService(CompaniesRepository companiesRepository, CompaniesConverter companiesConverter) {
        this.companiesRepository = companiesRepository;
        this.companiesConverter = companiesConverter;
    }

    @Override
    public CompaniesDto save(CompaniesDto entity) {
        CompaniesDao savedCompany = companiesRepository.save(companiesConverter.to(entity));
        return companiesConverter.from(savedCompany);
    }

    @Override
    public CompaniesDto update(CompaniesDto entity) {
        CompaniesDao updatedCompany = companiesRepository.update(companiesConverter.to(entity));
        return companiesConverter.from(updatedCompany);
    }

    @Override
    public void delete(CompaniesDto entity) {
        companiesRepository.delete(companiesConverter.to(entity));
    }

    @Override
    public CompaniesDto findById(Integer id) {
        CompaniesDao byId = companiesRepository.findById(id);
        return companiesConverter.from(byId);
    }

    @Override
    public List<CompaniesDto> findAll() {
        List<CompaniesDto> companiesDtoList = new ArrayList<>();
        List<CompaniesDao> companiesDaoList = companiesRepository.findAll();
        for (CompaniesDao dao: companiesDaoList) {
            companiesDtoList.add(companiesConverter.from(dao));
        }
        return companiesDtoList;
    }
}
