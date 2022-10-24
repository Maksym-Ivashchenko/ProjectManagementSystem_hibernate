package ua.goit.homeworkhibernate.model.dao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projects")
public class ProjectsDao {
    Integer id;
    String projectName;
    String projectType;
    String comments;
    Integer cost;
    LocalDate dateCreated;
    Set<DevelopersDao> developers;
    Set<CompaniesDao> companies;
    Set<CustomersDao> customers;

    public ProjectsDao() {
    }

    public ProjectsDao(Integer id, String projectName, String projectType, String comments, Integer cost, LocalDate dateCreated) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
        this.dateCreated = dateCreated;
    }

    public ProjectsDao(String projectName, String projectType, String comments, Integer cost, LocalDate dateCreated) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
        this.dateCreated = dateCreated;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "project_name", length = 45)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "project_type", length = 45)
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Column(name = "comments", length = 45)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column(name = "date_created")
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @ManyToMany(mappedBy = "projects")
    public Set<DevelopersDao> getDevelopers() {
        return developers;
    }

    @ManyToMany(mappedBy = "projects")
    public Set<CompaniesDao> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompaniesDao> companies) {
        this.companies = companies;
    }

    public void setDevelopers(Set<DevelopersDao> developers) {
        this.developers = developers;
    }

    @ManyToMany(mappedBy = "projects")
    public Set<CustomersDao> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomersDao> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectsDao)) return false;
        ProjectsDao that = (ProjectsDao) o;
        return Objects.equals(id, that.id) && Objects.equals(projectName, that.projectName) && Objects.equals(projectType, that.projectType) && Objects.equals(comments, that.comments) && Objects.equals(cost, that.cost) && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, projectType, comments, cost, dateCreated);
    }

    @Override
    public String toString() {
        return "ProjectsDao{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", comments='" + comments + '\'' +
                ", cost=" + cost +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
