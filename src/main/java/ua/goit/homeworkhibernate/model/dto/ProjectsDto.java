package ua.goit.homeworkhibernate.model.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectsDto {
    Integer id;
    String projectName;
    String projectType;
    String comments;
    Integer cost;
    LocalDate dateCreated;

    public ProjectsDto() {
    }

    public ProjectsDto(Integer id, String projectName, String projectType, String comments, Integer cost, LocalDate dateCreated) {
        this.id = id;
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
        this.dateCreated = dateCreated;
    }

    public ProjectsDto(String projectName, String projectType, String comments, Integer cost, LocalDate dateCreated) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.comments = comments;
        this.cost = cost;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectsDto)) return false;
        ProjectsDto that = (ProjectsDto) o;
        return Objects.equals(id, that.id) && Objects.equals(projectName, that.projectName) && Objects.equals(projectType, that.projectType) && Objects.equals(comments, that.comments) && Objects.equals(cost, that.cost) && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, projectType, comments, cost, dateCreated);
    }

    @Override
    public String toString() {
        return "ProjectsDto{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", comments='" + comments + '\'' +
                ", cost=" + cost +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
