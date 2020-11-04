package com.joole.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"productLine", "category_id"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productLineId;

    @Column
    private String productLine;

    @OneToMany(mappedBy = "productLine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductSeries> productSeriesList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "productLine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LineSpecs> lineSpecsList;

    @OneToMany(mappedBy = "productLine", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Model> models;

    public ProductLine() {}

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }


    @JsonIgnore
    public List<ProductSeries> getProductSeriesList() {
        return productSeriesList;
    }

    public void setProductSeriesList(List<ProductSeries> productSeriesList) {
        this.productSeriesList = productSeriesList;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @JsonManagedReference
    @JsonIgnore
    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @JsonIgnore
    public List<LineSpecs> getLineSpecsList() {
        return lineSpecsList;
    }

    public void setLineSpecsList(List<LineSpecs> lineSpecsList) {
        this.lineSpecsList = lineSpecsList;
    }

}
