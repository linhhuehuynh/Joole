package com.joole.service;

import com.joole.dao.ModelDetailsRepo;
import com.joole.dao.ModelRepo;
import com.joole.entity.Model;
import com.joole.entity.ModelDetails;
import com.joole.entity.ModelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelDetailsService {

    @Autowired
    private ModelDetailsRepo modelDetailsRepo;

    @Autowired
    private ModelRepo modelRepo;

    public Optional<List<ModelDetails>> getAllDetailsByModelId(long modelId) {
        Optional<Model> model = modelRepo.findById(modelId);

        if (!model.isPresent()) return null;

        Optional<List<ModelDetails>> modelDetails = modelDetailsRepo.getAllDetailsByModelId(modelId);
        if (modelDetails.isPresent()) return modelDetails;

        return Optional.empty();
    }
}
