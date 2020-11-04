package com.joole.dao;

import com.joole.entity.LineSpecs;
import com.joole.entity.SpecsProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecsPropertyRepo extends JpaRepository<SpecsProperty, Long>, JpaSpecificationExecutor<SpecsProperty> {

    SpecsProperty findBySpecsProperty(String specsProperty);
}
