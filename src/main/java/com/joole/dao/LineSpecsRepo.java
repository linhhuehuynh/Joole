package com.joole.dao;

import com.joole.entity.LineSpecs;
import com.joole.entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LineSpecsRepo extends JpaRepository<LineSpecs, Long> {

    @Query("select l from LineSpecs l where l.productLine.productLine = ?1")
    Optional<List<LineSpecs>> getAllLineSpecsByProductLine(String productLine);


}
