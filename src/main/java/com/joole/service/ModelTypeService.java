package com.joole.service;

import com.joole.dao.ModelRepo;
import com.joole.dao.ModelTypeRepo;
import com.joole.entity.Model;
import com.joole.entity.ModelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelTypeService {

    @Autowired
    private ModelRepo modelRepo;

    @Autowired
    private ModelTypeRepo modelTypeRepo;

    public Optional<List<ModelType>> getAllTypesByModelId(long modelId) {
        Optional<Model> model = modelRepo.findById(modelId);

        if (!model.isPresent()) return null;

        Optional<List<ModelType>> modelTypes = modelTypeRepo.getAllTypesByModelId(modelId);
        if (modelTypes.isPresent()) return modelTypes;

        return Optional.empty();

    }
}
