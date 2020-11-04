package com.joole.controller;

import com.joole.entity.Model;
import com.joole.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getAllModelsByProductLine(@PathVariable String name) {
        Optional<List<Model>> models = modelService.getAllModelsByProductLine(name);

        if (models == null) return new ResponseEntity<>("Product line not found!", HttpStatus.NOT_FOUND);
        if (models.isPresent()) return new ResponseEntity<>(models.get(), HttpStatus.OK);

        return new ResponseEntity<>("No product models found", HttpStatus.NOT_FOUND);
    }
}