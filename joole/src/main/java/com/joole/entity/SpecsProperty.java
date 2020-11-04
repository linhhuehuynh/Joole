package com.joole.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SpecsProperty{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specsPropertyId;

    private String specsProperty;


    @OneToMany(mappedBy = "specsProperty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LineSpecs> lineSpecsList;

    public SpecsProperty() {
    }

    public Long getSpecsPropertyId() {
        return specsPropertyId;
    }

    public void setSpecsPropertyId(Long specsPropertyId) {
        this.specsPropertyId = specsPropertyId;
    }

    public String getSpecsProperty() {
        return specsProperty;
    }

    public void setSpecsProperty(String specsProperty) {
        this.specsProperty = specsProperty;
    }


    @JsonIgnore
    public Set<LineSpecs> getLineSpecsList() {
        return lineSpecsList;
    }

    public void setLineSpecsList(Set<LineSpecs> lineSpecsList) {
        this.lineSpecsList = lineSpecsList;
    }

}
