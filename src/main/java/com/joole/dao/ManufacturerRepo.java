package com.joole.dao;

import com.joole.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
}
