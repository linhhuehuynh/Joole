package com.joole.dao;

import com.joole.entity.ModelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ModelDetailsRepo extends JpaRepository<ModelDetails, Long> {

    @Query("select m from ModelDetails m where m.model.id = ?1")
    Optional<List<ModelDetails>> getAllDetailsByModelId(long modelId);
}
