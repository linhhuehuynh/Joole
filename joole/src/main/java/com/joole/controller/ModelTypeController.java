package com.joole.controller;

import com.joole.entity.ModelType;
import com.joole.entity.ProductLine;
import com.joole.service.ModelService;
import com.joole.service.ModelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/modeltype")
public class ModelTypeController {

    @Autowired
    private ModelTypeService modelTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllTypesByModelId(@PathVariable long id) {
        Optional<List<ModelType>> modelTypes = modelTypeService.getAllTypesByModelId(id);

        if (modelTypes == null) return new ResponseEntity<>("Model types not found!", HttpStatus.NOT_FOUND);
        if (modelTypes.isPresent()) return new ResponseEntity<>(modelTypes.get(), HttpStatus.OK);

        return new ResponseEntity<>("No model found!", HttpStatus.NOT_FOUND);
    }
}
