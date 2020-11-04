package com.joole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String model;

    @CreationTimestamp
    private Date verifiedDate;

    private String imgUrl;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "series_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductSeries productSeries;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_line_id", nullable = false)
    private ProductLine productLine;

    @OneToMany(mappedBy = "model", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ModelSpecs> modelSpecs;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ModelType> modelType;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ModelDetails> modelDetails;

    public Model() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSeries() {
        return productSeries.getSeries();
    }

    public String getManufacturer() {
        return productSeries.getManufacturer().getManufacturer();
    }

    public long getManufacturerId() {
        return productSeries.getManufacturer().getManufacturerId();
    }

    @JsonBackReference
    public ProductSeries getProductSeries() {
        return productSeries;
    }

    public void setProductSeries(ProductSeries productSeries) {
        this.productSeries = productSeries;
    }

    @JsonBackReference
    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    @JsonManagedReference
    public List<ModelSpecs> getModelSpecs() {
        return modelSpecs;
    }

    public void setModelSpecs(List<ModelSpecs> modelSpecs) {
        this.modelSpecs = modelSpecs;
    }

    @JsonManagedReference
    @JsonIgnore
    public List<ModelType> getModelType() {
        return modelType;
    }

    public void setModelType(List<ModelType> modelType) {
        this.modelType = modelType;
    }

    @JsonManagedReference
    @JsonIgnore
    public List<ModelDetails> getModelDetails() {
        return modelDetails;
    }

    public void setModelDetails(List<ModelDetails> modelDetails) {
        this.modelDetails = modelDetails;
    }
}

