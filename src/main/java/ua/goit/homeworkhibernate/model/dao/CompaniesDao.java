package ua.goit.homeworkhibernate.model.dao;

import java.util.Objects;
import java.util.Set;

public class CompaniesDao {
    Integer id;
    String companyName;
    String city;
    String email;
    Set<ProjectsDao> projects;

    public CompaniesDao() {
    }

    public CompaniesDao(Integer id, String companyName, String city, String email) {
        this.id = id;
        this.companyName = companyName;
        this.city = city;
        this.email = email;
    }

    public CompaniesDao(String companyName, String city, String email) {
        this.companyName = companyName;
        this.city = city;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ProjectsDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectsDao> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "CompaniesDao{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompaniesDao)) return false;
        CompaniesDao that = (CompaniesDao) o;
        return Objects.equals(id, that.id) && Objects.equals(companyName, that.companyName) && Objects.equals(city, that.city) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, city, email);
    }
}
