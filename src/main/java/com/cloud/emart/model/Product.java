package com.cloud.emart.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 4121277586957094255L;

    @Id
    @GeneratedValue
    @Column(name="PRODUCT_ID")
    private int productId;

    @Column(name="PRODUCT_NAME")
    @NotEmpty(message = "The product name must not be null.")
    private String productName;

    @Column(name="PRODUCT_CATEGORY")
    private String productCategory;

    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name="PRODUCT_PRICE")
    @Min(value = 0, message = "The product price must not be less than zero.")
    private Double productPrice;

    @Column(name="PRODUCT_CONDITION")
    private String productCondition;

    @Column(name="PRODUCT_STATUS")
    private String productStatus;

    @Column(name="PRODUCT_UNIT_IN_STOCK")
    @Min(value = 0, message = "The product unit must not be less than zero.")
    private int unitInStock;

    @Column(name="PRODUCT_MANUFACTURER")
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
