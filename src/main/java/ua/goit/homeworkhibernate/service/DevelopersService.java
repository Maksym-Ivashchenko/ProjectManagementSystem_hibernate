package ua.goit.homeworkhibernate.service;

import ua.goit.homeworkhibernate.model.dao.DevelopersDao;
import ua.goit.homeworkhibernate.model.dto.DevelopersDto;
import ua.goit.homeworkhibernate.exceptions.DeveloperAlreadyExistException;
import ua.goit.homeworkhibernate.repository.DevelopersRepository;
import ua.goit.homeworkhibernate.service.convert.DevelopersConverter;

import java.util.ArrayList;
import java.util.List;

public class DevelopersService implements Service<DevelopersDto> {
    private final DevelopersRepository developersRepository;
    private final DevelopersConverter developersConverter;

    public DevelopersService(DevelopersRepository developersRepository, DevelopersConverter developersConverter) {
        this.developersRepository = developersRepository;
        this.developersConverter = developersConverter;
    }

    @Override
    public DevelopersDto save(DevelopersDto dto) {
        DevelopersDao savedDeveloper = developersRepository.save(developersConverter.to(dto));
        DevelopersDto developersDto = developersConverter.from(savedDeveloper);
        validateDeveloper(dto, developersDto);
        return developersDto;
    }

    @Override
    public DevelopersDto update(DevelopersDto dto) {
        DevelopersDao dao = developersRepository.update(developersConverter.to(dto));
        return developersConverter.from(dao);
    }

    @Override
    public void delete(DevelopersDto dto) {
        developersRepository.delete(developersConverter.to(dto));
    }

    @Override
    public DevelopersDto findById(Integer id) {
        DevelopersDao byId = developersRepository.findById(id);
        return developersConverter.from(byId);
    }

    @Override
    public List<DevelopersDto> findAll() {
        List<DevelopersDto> developersDtoList = new ArrayList<>();
        List<DevelopersDao> developersDaoList = developersRepository.findAll();
        for (DevelopersDao dao : developersDaoList) {
            developersDtoList.add(developersConverter.from(dao));
        }
        return developersDtoList;
    }

    public List<DevelopersDto> getListOfAllDevelopersByBranch(String branch) {
        List<DevelopersDto> developersDtoList = new ArrayList<>();
        List<DevelopersDao> list = developersRepository.getListOfAllDevelopersByBranch(branch);
        for (DevelopersDao dao : list) {
            developersDtoList.add(developersConverter.from(dao));
        }
        return developersDtoList;
    }

    public List<DevelopersDto> getListOfAllDevelopersBySkillLevel(String skillLevel) {
        List<DevelopersDto> developersDtoList = new ArrayList<>();
        List<DevelopersDao> list = developersRepository.getListOfAllDevelopersBySkillLevel(skillLevel);
        for (DevelopersDao dao : list) {
            developersDtoList.add(developersConverter.from(dao));
        }
        return developersDtoList;
    }

    public List<DevelopersDto> getListOfProjectDevelopers(String projectName) {
        List<DevelopersDto> developersDtoList = new ArrayList<>();
        List<DevelopersDao> listOfProjectDevelopers = developersRepository.getListOfProjectDevelopers(projectName);
        for (DevelopersDao dao: listOfProjectDevelopers) {
            developersDtoList.add(developersConverter.from(dao));
        }
        return developersDtoList;
    }

    private void validateDeveloper(DevelopersDto savedDeveloper, DevelopersDto newDeveloper) {
        if(!savedDeveloper.getDeveloperName().equals(newDeveloper.getDeveloperName()) ||
                !savedDeveloper.getAge().equals(newDeveloper.getAge())) {
            throw new DeveloperAlreadyExistException(String.format("Developer with name %s already exist with different " +
                    "age %s", savedDeveloper.getDeveloperName(), savedDeveloper.getAge()));
        }
    }
}
