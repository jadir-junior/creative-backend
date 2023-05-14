package com.jj.creative.domain.businessUnit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessUnitService {
    @Autowired
    BusinessUnitRepository businessUnitRepository;

    public List<BusinessUnit> findAll(String name) {
        System.out.println("entrou aqui!!");
        if (!name.isEmpty()) {
            return businessUnitRepository.findByNameContainsIgnoreCase(name);
        }

        return businessUnitRepository.findAll();
    }

    public BusinessUnit create(BusinessUnit businessUnit) {
        return businessUnitRepository.save(businessUnit);
    }

}
