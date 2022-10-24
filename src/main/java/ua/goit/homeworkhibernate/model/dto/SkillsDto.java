package ua.goit.homeworkhibernate.model.dto;

import java.util.Objects;

public class SkillsDto {
    Integer id;
    String branch;
    String skillLevel;

    public SkillsDto() {
    }

    public SkillsDto(Integer id, String branch, String skillLevel) {
        this.id = id;
        this.branch = branch;
        this.skillLevel = skillLevel;
    }

    public SkillsDto(String branch, String skillLevel) {
        this.branch = branch;
        this.skillLevel = skillLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillsDto)) return false;
        SkillsDto skillsDto = (SkillsDto) o;
        return Objects.equals(id, skillsDto.id) && Objects.equals(branch, skillsDto.branch) && Objects.equals(skillLevel, skillsDto.skillLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branch, skillLevel);
    }

    @Override
    public String toString() {
        return "SkillsDto{" +
                "id=" + id +
                ", branch='" + branch + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                '}';
    }
}
