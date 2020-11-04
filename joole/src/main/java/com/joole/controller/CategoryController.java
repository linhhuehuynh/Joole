package com.joole.controller;

import com.joole.entity.Category;
import com.joole.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Created category successfully!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) return new ResponseEntity<>(category.get(), HttpStatus.OK);
        return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) return new ResponseEntity<>("No categories found!", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
