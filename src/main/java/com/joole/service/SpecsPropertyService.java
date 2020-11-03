package com.joole.service;

import com.joole.dao.ProductLineRepo;
import com.joole.dao.SpecsPropertyRepo;
import com.joole.entity.ProductLine;
import com.joole.entity.SpecsProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecsPropertyService {

    @Autowired
    private SpecsPropertyRepo specsPropertyRepo;

    public void addSpecs(SpecsProperty specsProperty) {
        specsPropertyRepo.save(specsProperty);
    }

}
