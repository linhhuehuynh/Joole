package com.joole.dao;

import com.joole.entity.Model;
import com.joole.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelRepo extends JpaRepository<Model, Long> {

    @Query("select m from Model m where m.productLine.productLine= ?1")
    Optional<List<Model>> getAllModelsByProductLine(String productLine);
}
