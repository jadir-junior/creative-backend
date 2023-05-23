package com.jj.creative.domain.businessUnit.dto;

import org.springframework.stereotype.Component;

import com.jj.creative.domain.businessUnit.BusinessUnit;

@Component
public class BusinessUnitMapper {
    public BusinessUnit toModel(BusinessUnitDto businessUnitDto) {
        BusinessUnit businessUnit = new BusinessUnit();

        businessUnit.setName(businessUnitDto.name());

        return businessUnit;
    }

    public BusinessUnitDto toDTO(BusinessUnit businessUnit) {
        if (businessUnit == null) {
            return null;
        }

        return new BusinessUnitDto(businessUnit.getId(), businessUnit.getName());
    }
}
