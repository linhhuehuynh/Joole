package com.joole.service;

import com.joole.dao.ManufacturerRepo;
import com.joole.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    public Optional<Manufacturer> getManufacturerById(long id) {
        return manufacturerRepo.findById(id);
    }
}
