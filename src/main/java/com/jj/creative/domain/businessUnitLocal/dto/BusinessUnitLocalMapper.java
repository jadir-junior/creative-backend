package com.jj.creative.domain.businessUnitLocal.dto;

import org.springframework.stereotype.Component;

import com.jj.creative.domain.businessUnitLocal.BusinessUnitLocal;

@Component
public class BusinessUnitLocalMapper {
    public BusinessUnitLocal toModel(BusinessUnitLocalDto dto) {
        BusinessUnitLocal businessUnitLocal = new BusinessUnitLocal();

        businessUnitLocal.setName(dto.name());
        businessUnitLocal.setBusinessUnitId(dto.businessUnitId());

        return businessUnitLocal;
    }

    public BusinessUnitLocalDto toDto(BusinessUnitLocal entity) {
        if (entity == null) {
            return null;
        }

        return new BusinessUnitLocalDto(entity.getId(), entity.getName(), entity.getBusinessUnitId());
    }
}
