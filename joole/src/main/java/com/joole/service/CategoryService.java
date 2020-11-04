package com.joole.service;

import com.joole.dao.CategoryRepo;
import com.joole.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public Optional<Category> getCategoryById(long id) {
        return categoryRepo.findById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

}
