package com.joole.controller;

import com.joole.entity.ModelDetails;
import com.joole.entity.ModelType;
import com.joole.service.ModelDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/modeldetails")
public class ModelDetailsController {

    @Autowired
    private ModelDetailsService modelDetailsService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllDetailsByModelId(@PathVariable long id) {
        Optional<List<ModelDetails>> modelDetails = modelDetailsService.getAllDetailsByModelId(id);

        if (modelDetails == null) return new ResponseEntity<>("Model not found!", HttpStatus.NOT_FOUND);
        if (modelDetails.isPresent()) return new ResponseEntity<>(modelDetails.get(), HttpStatus.OK);

        return new ResponseEntity<>("No model details found!", HttpStatus.NOT_FOUND);
    }
}
