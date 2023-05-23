package com.jj.creative.domain.businessUnit;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jj.creative.domain.businessUnit.dto.BusinessUnitDto;
import com.jj.creative.utils.pagination.ResponsePagination;

@RestController
@RequestMapping("/api/business-unit")
public class BusinessUnitController {
    @Autowired
    BusinessUnitService businessUnitService;

    @GetMapping
    public ResponsePagination<BusinessUnit> findAll(@RequestParam(required = false) String name) {
        return businessUnitService.findAll(name);
    }

    @PostMapping
    public BusinessUnitDto create(@RequestBody BusinessUnit businessUnit) {
        return businessUnitService.create(businessUnit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        businessUnitService.delete(id);
    }
}
