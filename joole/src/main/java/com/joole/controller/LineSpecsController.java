package com.joole.controller;

import com.joole.dao.ProductLineRepo;
import com.joole.entity.Category;
import com.joole.entity.LineSpecs;
import com.joole.entity.ProductLine;
import com.joole.entity.SpecsProperty;
import com.joole.service.LineSpecService;
import com.joole.service.SpecsPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/linespecs")
public class LineSpecsController {

    @Autowired
    private LineSpecService lineSpecService;

    @PostMapping("")
    public ResponseEntity<?> addLineSpecs(@RequestBody LineSpecs lineSpecs) {
        Optional<LineSpecs> res = lineSpecService.addLineSpecs(lineSpecs);
        if(res.isPresent()) {
            return new ResponseEntity<>(res.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Product Line or Product Line Specs Not Found!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/list")
    public ResponseEntity<?> addLineSpecsList(@RequestBody List<LineSpecs> lineSpecsList) {
        lineSpecService.addLineSpecsList(lineSpecsList);
        return new ResponseEntity<>("Added Product Specs List Successfully!", HttpStatus.OK);
        }

    @GetMapping("")
    public ResponseEntity<?> getAllLineSpecs() {
        List<LineSpecs> lineSpecs = lineSpecService.getAllLineSpecs();
        if (lineSpecs.isEmpty()) return new ResponseEntity<>("No specs found!", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(lineSpecs, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getLineSpecsByLine(@PathVariable String name) {
        Optional<List<LineSpecs>> lineSpecs = lineSpecService.getAllLineSpecsByLine(name);

        if (lineSpecs == null) return new ResponseEntity<>("Product line not found!", HttpStatus.NOT_FOUND);
        if (lineSpecs.isPresent()) return new ResponseEntity<>(lineSpecs.get(), HttpStatus.OK);

        return new ResponseEntity<>("No product line specs found!", HttpStatus.NOT_FOUND);
    }

}


