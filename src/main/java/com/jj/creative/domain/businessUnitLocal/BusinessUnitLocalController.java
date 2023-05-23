package com.jj.creative.domain.businessUnitLocal;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jj.creative.utils.pagination.ResponsePagination;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/business-unit-local")
public class BusinessUnitLocalController {
    @Autowired
    BusinessUnitLocalService businessUnitLocalService;

    @GetMapping("/{businessUnitId}")
    public ResponsePagination<BusinessUnitLocal> list(@PathVariable UUID businessUnitId,
            @RequestParam(required = false) String name) {
        return businessUnitLocalService.list(businessUnitId, name);
    }

    @PostMapping
    public BusinessUnitLocal create(@RequestBody BusinessUnitLocal businessUnitLocal) {
        return businessUnitLocalService.create(businessUnitLocal);
    }
}
