package ua.goit.homeworkhibernate.model.dto;

import java.util.Objects;

public class CompaniesDto {
    Integer id;
    String companyName;
    String city;
    String email;

    public CompaniesDto() {
    }

    public CompaniesDto(Integer id, String companyName, String city, String email) {
        this.id = id;
        this.companyName = companyName;
        this.city = city;
        this.email = email;
    }

    public CompaniesDto(String companyName, String city, String email) {
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

    @Override
    public String toString() {
        return "CompaniesDto{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompaniesDto)) return false;
        CompaniesDto that = (CompaniesDto) o;
        return Objects.equals(id, that.id) && Objects.equals(companyName, that.companyName) && Objects.equals(city, that.city) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, city, email);
    }
}
