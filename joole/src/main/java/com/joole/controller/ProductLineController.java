package com.joole.controller;

import com.joole.entity.ProductLine;
import com.joole.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/productline")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductLinesByCategoryId(@PathVariable long id) {
        Optional<List<ProductLine>> productLines = productLineService.getProductLinesByCategoryId(id);

        if (productLines == null) return new ResponseEntity<>("Category not found!", HttpStatus.NOT_FOUND);
        if (productLines.isPresent()) return new ResponseEntity<>(productLines.get(), HttpStatus.OK);

        return new ResponseEntity<>("No product lines found!", HttpStatus.NOT_FOUND);
    }
}
