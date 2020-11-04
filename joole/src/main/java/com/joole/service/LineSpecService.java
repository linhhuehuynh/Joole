package com.joole.service;

import com.joole.dao.LineSpecsRepo;

import com.joole.dao.ProductLineRepo;
import com.joole.dao.SpecsPropertyRepo;
import com.joole.entity.LineSpecs;

import com.joole.entity.ProductLine;
import com.joole.entity.SpecsProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LineSpecService {

    @Autowired
    private LineSpecsRepo lineSpecsRepo;

    @Autowired
    private ProductLineRepo productLineRepo;

    @Autowired
    private SpecsPropertyRepo specsPropertyRepo;

    public Optional<LineSpecs> addLineSpecs(LineSpecs lineSpecs) {
        Optional<ProductLine> productLine = productLineRepo.findById(lineSpecs.getProductLine().getProductLineId());
        Optional<SpecsProperty> specsProperty = specsPropertyRepo.findById(lineSpecs.getSpecsProperty().getSpecsPropertyId());

        if(!productLine.isPresent() || !specsProperty.isPresent()) {
            return Optional.empty();
        }

        LineSpecs createdLineSpecs = lineSpecsRepo.save(lineSpecs);
        Optional<LineSpecs> result = Optional.of(createdLineSpecs);
        if(result.isPresent()) {
            return result;
        }
        return Optional.empty();
    }

    public void addLineSpecsList(List<LineSpecs> lineSpecsList) {
        lineSpecsRepo.saveAll(lineSpecsList);
    }

    public Optional<List<LineSpecs>> getAllLineSpecsByLine(String name){
        Optional<ProductLine> productLine = productLineRepo.findByProductLine(name);
        if (!productLine.isPresent()) return null;

        Optional<List<LineSpecs>> lineSpecs = lineSpecsRepo.getAllLineSpecsByProductLine(name);

        if (lineSpecs.isPresent()) return lineSpecs;

        return Optional.empty();
    }

    public List<LineSpecs> getAllLineSpecs() {
        return lineSpecsRepo.findAll();
    }


}
