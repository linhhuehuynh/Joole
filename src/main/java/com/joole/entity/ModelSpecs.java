package com.joole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ModelSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelSpecsId;

    private String name;
    private double defaultOrMin;
    private double max;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Model model;

    public ModelSpecs() {
    }

    public Long getModelSpecsId() {
        return modelSpecsId;
    }

    public void setModelSpecsId(Long modelSpecsId) {
        this.modelSpecsId = modelSpecsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDefaultOrMin() {
        return defaultOrMin;
    }

    public void setDefaultOrMin(double defaultOrMin) {
        this.defaultOrMin = defaultOrMin;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @JsonBackReference
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
