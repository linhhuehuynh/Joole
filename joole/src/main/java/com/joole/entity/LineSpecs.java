package com.joole.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"specs_property_id", "product_line_id"}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LineSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linesSpecsId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "specs_property_id", nullable = false)
    private SpecsProperty specsProperty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_line_id", nullable = false)
    private ProductLine productLine;

    private int min;

    private int max;

    public LineSpecs() {
    }

    public Long getLinesSpecsId() {
        return linesSpecsId;
    }

    public void setLinesSpecsId(Long linesSpecsId) {
        this.linesSpecsId = linesSpecsId;
    }

    public SpecsProperty getSpecsProperty() {
        return specsProperty;
    }

    public void setSpecsProperty(SpecsProperty specsProperty) {
        this.specsProperty = specsProperty;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
