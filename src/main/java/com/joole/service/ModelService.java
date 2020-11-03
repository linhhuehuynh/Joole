package com.joole.service;

import com.joole.dao.ModelRepo;
import com.joole.dao.ProductLineRepo;
import com.joole.entity.Model;
import com.joole.entity.ProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepo modelRepo;

    @Autowired
    private ProductLineRepo productLineRepo;

    public Optional<List<Model>> getAllModelsByProductLine(String name){
        Optional<ProductLine> productLine = productLineRepo.findByProductLine(name);
        if(!productLine.isPresent()) return null;

        Optional<List<Model>> models = modelRepo.getAllModelsByProductLine(name);
        if (models.isPresent()) return models;

        return Optional.empty();
    }
}
