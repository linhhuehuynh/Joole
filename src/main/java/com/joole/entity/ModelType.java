package com.joole.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ModelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelTypeId;

    private String name;
    private String value;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "model_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Model model;

    public ModelType() {
    }

    public Long getModelTypeId() {
        return modelTypeId;
    }

    public void setModelTypeId(Long modelTypeId) {
        this.modelTypeId = modelTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonBackReference
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
