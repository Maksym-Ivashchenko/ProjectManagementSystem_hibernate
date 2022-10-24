package ua.goit.homeworkhibernate.model.dao;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")
public class CustomersDao {
    Integer id;
    String customerName;
    String country;
    String email;
    Set<ProjectsDao> projects;

    public CustomersDao() {
    }

    public CustomersDao(Integer id, String customerName, String country, String email) {
        this.id = id;
        this.customerName = customerName;
        this.country = country;
        this.email = email;
    }

    public CustomersDao(String customerName, String country, String email) {
        this.customerName = customerName;
        this.country = country;
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

    @Column(name = "customer_name", length = 45)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "country", length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "email", length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    @JoinTable(name = "customers_projects",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    public Set<ProjectsDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectsDao> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "CustomersDao{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomersDao)) return false;
        CustomersDao that = (CustomersDao) o;
        return Objects.equals(id, that.id) && Objects.equals(customerName, that.customerName) && Objects.equals(country, that.country) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, country, email);
    }
}
