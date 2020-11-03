package com.joole.dao;

import com.joole.entity.ModelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelTypeRepo extends JpaRepository<ModelType, Long> {

    @Query("select m from ModelType m where m.model.id = ?1")
    Optional<List<ModelType>> getAllTypesByModelId(long modelId);
}
