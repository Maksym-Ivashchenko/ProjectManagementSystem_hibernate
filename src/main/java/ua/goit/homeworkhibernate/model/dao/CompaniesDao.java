package ua.goit.homeworkhibernate.model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "companies")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "company_name", length = 45)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "city", length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    @JoinTable(name = "companies_projects",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
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
