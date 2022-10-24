package ua.goit.homeworkhibernate.model.dto;

import java.util.Objects;

public class CustomersDto {
    Integer id;
    String customerName;
    String country;
    String email;

    public CustomersDto() {
    }

    public CustomersDto(Integer id, String customerName, String country, String email) {
        this.id = id;
        this.customerName = customerName;
        this.country = country;
        this.email = email;
    }

    public CustomersDto(String customerName, String country, String email) {
        this.customerName = customerName;
        this.country = country;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomersDto)) return false;
        CustomersDto that = (CustomersDto) o;
        return Objects.equals(id, that.id) && Objects.equals(customerName, that.customerName) && Objects.equals(country, that.country) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, country, email);
    }

    @Override
    public String toString() {
        return "CustomersDto{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
