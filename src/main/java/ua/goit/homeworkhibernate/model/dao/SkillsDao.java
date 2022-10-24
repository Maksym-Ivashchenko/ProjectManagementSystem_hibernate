package ua.goit.homeworkhibernate.model.dao;

import java.util.Objects;
import java.util.Set;

public class SkillsDao {
    Integer id;
    String branch;
    String skillLevel;
    Set<DevelopersDao> developers;

    public SkillsDao() {
    }

    public SkillsDao(Integer id, String branch, String skillLevel) {
        this.id = id;
        this.branch = branch;
        this.skillLevel = skillLevel;
    }

    public SkillsDao(String branch, String skillLevel) {
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

    public Set<DevelopersDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DevelopersDao> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillsDao)) return false;
        SkillsDao skillsDao = (SkillsDao) o;
        return Objects.equals(id, skillsDao.id) && Objects.equals(branch, skillsDao.branch) && Objects.equals(skillLevel, skillsDao.skillLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branch, skillLevel);
    }

    @Override
    public String toString() {
        return "SkillsDao{" +
                "id=" + id +
                ", branch='" + branch + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                '}';
    }
}
