package ua.goit.homeworkhibernate.model.dao;

import java.util.Objects;
import java.util.Set;

public class DevelopersDao {
    Integer id;
    String developerName;
    Integer age;
    String gender;
    String different;
    Integer salary;
    Set<ProjectsDao> projects;
    Set<SkillsDao> skills;

    public DevelopersDao() {
    }

    public DevelopersDao(Integer id, String developerName, Integer age, String gender,
                         String different, Integer salary) {
        this.id = id;
        this.developerName = developerName;
        this.age = age;
        this.gender = gender;
        this.different = different;
        this.salary = salary;
    }

    public DevelopersDao(String developerName, Integer age, String gender, String different, Integer salary) {
        this.developerName = developerName;
        this.age = age;
        this.gender = gender;
        this.different = different;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDifferent() {
        return different;
    }

    public void setDifferent(String different) {
        this.different = different;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Set<ProjectsDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectsDao> projects) {
        this.projects = projects;
    }

    public Set<SkillsDao> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillsDao> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevelopersDao)) return false;
        DevelopersDao that = (DevelopersDao) o;
        return Objects.equals(id, that.id) && Objects.equals(developerName, that.developerName) && Objects.equals(age, that.age) && Objects.equals(gender, that.gender) && Objects.equals(different, that.different) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, developerName, age, gender, different, salary);
    }

    @Override
    public String toString() {
        return "\n{DevelopersDao:\s" +
                "id = " + id +
                ", developerName = " + developerName +
                ", age = " + age +
                ", gender = " + gender +
                ", different = " + different +
                ", salary = " + salary + "}";
    }
}
