package com.cloud.emart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 446012332350788969L;

    @Id
    @GeneratedValue
    @Column(name="CUSTOMER_ID")
    private int customerId;

    @Column(name="CUSTOMER_NAME")
    @NotEmpty(message = "The customer name must not be null.")
    private String customerName;

    @Column(name="CUSTOMER_EMAIL")
    @NotEmpty(message = "The customer email must not be null.")
    private String customerEmail;

    @Column(name="CUSTOMER_PHONE")
    @NotEmpty(message = "The customer phone must not be null.")
    private String customerPhone;

    @Column(name="USERNAME")
    @NotEmpty(message = "The customer username must not be null.")
    private String username;

    @Column(name="PASSWORD")
    @NotEmpty(message = "The customer password must not be null.")
    private String password;

    @Column(name="STREET_NAME")
    @NotEmpty(message = "The street name must not be null.")
    private String streetName;

    @Column(name="APARTMENT_NUMBER")
    @NotEmpty(message = "The apartment number must not be null.")
    private String apartmentNumber;

    @Column(name="CITY")
    @NotEmpty(message = "The city must not be null.")
    private String city;

    @Column(name="STATE")
    @NotEmpty(message = "The state must not be null.")
    private String state;

    @Column(name="COUNTRY")
    @NotEmpty(message = "The country must not be null.")
    private String country;

    @Column(name="ZIPCODE")
    @NotEmpty(message = "The zipcode must not be null.")
    private String zipCode;

    @Column(name="ENABLED")
    private boolean enabled;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
