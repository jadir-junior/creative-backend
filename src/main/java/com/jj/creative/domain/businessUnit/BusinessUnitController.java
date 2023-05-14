package com.jj.creative.domain.businessUnit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/business-unit")
public class BusinessUnitController {
    @Autowired
    BusinessUnitService businessUnitService;

    @GetMapping
    public List<BusinessUnit> findAll(@RequestParam String name) {
        return businessUnitService.findAll(name);
    }

    @PostMapping
    public BusinessUnit create(@RequestBody BusinessUnit businessUnit) {
        return businessUnitService.create(businessUnit);
    }
}
