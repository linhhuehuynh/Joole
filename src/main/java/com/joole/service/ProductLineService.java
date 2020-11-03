package com.joole.service;

import com.joole.dao.CategoryRepo;
import com.joole.dao.ProductLineRepo;
import com.joole.entity.Category;
import com.joole.entity.ProductLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductLineService {

    @Autowired
    private ProductLineRepo productLineRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public Optional<List<ProductLine>> getProductLinesByCategoryId(long categoryId){
        Optional<Category> category = categoryRepo.findById(categoryId);
        if (!category.isPresent()) return null;

        Optional<List<ProductLine>> productLines = productLineRepo.getAllByCategoryId(categoryId);
        if (productLines.isPresent()) return productLines;

        return Optional.empty();
    }
}
