package com.joole.controller;

import com.joole.entity.ProductLine;
import com.joole.entity.SpecsProperty;
import com.joole.service.SpecsPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/specs")
public class SpecsPropertyController {

    @Autowired
    private SpecsPropertyService specsPropertyService;

    @PostMapping("")
    public ResponseEntity<?> addSpecs(@RequestBody SpecsProperty specsProperty) {
        specsPropertyService.addSpecs(specsProperty);
        return new ResponseEntity<>("Added Specs Successfully!", HttpStatus.OK);
    }

//    @PostMapping("/productline/{id}")
//    @ResponseBody
//    public ResponseEntity<?> addSpecsToProductLine(@RequestBody List<SpecsProperty> specsPropertyList, @PathVariable long id) {
//        Optional<ProductLine> productLine = specsPropertyService.addSpecsToProject(specsPropertyList, id);
//        if (productLine.isPresent()) {
//            return new ResponseEntity<>("Added Specs Successfully", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Product Line Not Found!", HttpStatus.NOT_FOUND);
//    }

//    @GetMapping("/productline/{id}")
//    @ResponseBody
//    public ResponseEntity<?> getSpecsByProductLineId(@PathVariable long id) {
//        List<SpecsProperty> specs = specsPropertyService.getSpecsByProductLineId(id);
//        if (specs.isEmpty()) {
//            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(specs, HttpStatus.OK);
//    }

//    @DeleteMapping("/productline/{id}")
//    @ResponseBody
//    public ResponseEntity<?> deleteAllSpecsFromProductLine(@PathVariable Integer id) {
//        specsPropertyService.(id);
//        return new ResponseEntity<>("Deleted All Resources Successfully under the Project!", HttpStatus.OK);
//    }

}
