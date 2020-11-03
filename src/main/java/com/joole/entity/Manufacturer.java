package com.joole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;

    @Column(unique = true, nullable = false)
    private String manufacturer;

    private String dept;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String web;

    private String salesName;
    private String salesPhone;
    private String salesEmail;
    private String salesWeb;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductSeries> productSeriesList;

    public Manufacturer() {
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getSalesPhone() {
        return salesPhone;
    }

    public void setSalesPhone(String salesPhone) {
        this.salesPhone = salesPhone;
    }

    public String getSalesEmail() {
        return salesEmail;
    }

    public void setSalesEmail(String salesEmail) {
        this.salesEmail = salesEmail;
    }

    public String getSalesWeb() {
        return salesWeb;
    }

    public void setSalesWeb(String salesWeb) {
        this.salesWeb = salesWeb;
    }

    @JsonManagedReference
    @JsonIgnore
    public List<ProductSeries> getProductSeriesList() {
        return productSeriesList;
    }

    public void setProductSeriesList(List<ProductSeries> productSeriesList) {
        this.productSeriesList = productSeriesList;
    }

}
