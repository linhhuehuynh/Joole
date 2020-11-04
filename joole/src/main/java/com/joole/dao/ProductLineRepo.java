package com.joole.dao;

import com.joole.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductLineRepo extends JpaRepository<ProductLine, Long>{

    @Query("select p from ProductLine p where p.category.categoryId = ?1")
    Optional<List<ProductLine>> getAllByCategoryId(long categoryId);

    @Query("select p from ProductLine p where p.productLine = ?1")
    Optional<ProductLine> findByProductLine(String productLine);


}
