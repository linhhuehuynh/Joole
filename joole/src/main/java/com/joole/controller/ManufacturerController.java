package com.joole.controller;

import com.joole.entity.Category;
import com.joole.entity.Manufacturer;
import com.joole.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getManufacturerById(@PathVariable long id) {
        Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(id);
        if (manufacturer.isPresent()) return new ResponseEntity<>(manufacturer.get(), HttpStatus.OK);
        return new ResponseEntity<>("Manufacturer not found", HttpStatus.NOT_FOUND);
    }
}
