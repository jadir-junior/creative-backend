package com.jj.creative.domain.businessUnitLocal;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jj.creative.domain.businessUnitLocal.dto.BusinessUnitLocalDto;
import com.jj.creative.utils.pagination.ResponsePagination;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/business-unit-local")
public class BusinessUnitLocalController {
    @Autowired
    BusinessUnitLocalService businessUnitLocalService;

    @GetMapping("/{businessUnitId}")
    public ResponsePagination<BusinessUnitLocalDto, BusinessUnitLocal> list(@PathVariable UUID businessUnitId,
            @RequestParam(required = false) String name) {
        return businessUnitLocalService.list(businessUnitId, name);
    }

    @PostMapping
    public BusinessUnitLocalDto create(
            @RequestBody BusinessUnitLocalDto businessUnitLocalDto) {
        return businessUnitLocalService.create(businessUnitLocalDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        businessUnitLocalService.delete(id);
    }
}
