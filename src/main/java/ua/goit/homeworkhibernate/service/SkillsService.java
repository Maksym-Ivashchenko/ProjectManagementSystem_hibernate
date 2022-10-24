package ua.goit.homeworkhibernate.service;

import ua.goit.homeworkhibernate.model.dao.SkillsDao;
import ua.goit.homeworkhibernate.model.dto.SkillsDto;
import ua.goit.homeworkhibernate.repository.SkillsRepository;
import ua.goit.homeworkhibernate.service.convert.SkillsConverter;

import java.util.ArrayList;
import java.util.List;

public class SkillsService implements Service<SkillsDto> {
    private final SkillsRepository skillsRepository;
    private final SkillsConverter skillsConverter;

    public SkillsService(SkillsRepository skillsRepository, SkillsConverter skillsConverter) {
        this.skillsRepository = skillsRepository;
        this.skillsConverter = skillsConverter;
    }

    @Override
    public SkillsDto save(SkillsDto entity) {
        SkillsDao savedSkill = skillsRepository.save(skillsConverter.to(entity));
        return skillsConverter.from(savedSkill);
    }

    @Override
    public SkillsDto update(SkillsDto entity) {
        SkillsDao updatedSkill = skillsRepository.update(skillsConverter.to(entity));
        return skillsConverter.from(updatedSkill);
    }

    @Override
    public void delete(SkillsDto entity) {
        skillsRepository.delete(skillsConverter.to(entity));
    }

    @Override
    public SkillsDto findById(Integer id) {
        SkillsDao byId = skillsRepository.findById(id);
        return skillsConverter.from(byId);
    }

    @Override
    public List<SkillsDto> findAll() {
        List<SkillsDto> skillsDtoList = new ArrayList<>();
        List<SkillsDao> skillsDaoList = skillsRepository.findAll();
        for (SkillsDao dao: skillsDaoList) {
            skillsDtoList.add(skillsConverter.from(dao));
        }
        return skillsDtoList;
    }
}
