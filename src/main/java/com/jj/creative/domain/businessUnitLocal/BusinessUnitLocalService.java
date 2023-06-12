package com.jj.creative.domain.businessUnitLocal;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jj.creative.domain.businessUnitLocal.dto.BusinessUnitLocalDto;
import com.jj.creative.domain.businessUnitLocal.dto.BusinessUnitLocalMapper;
import com.jj.creative.utils.pagination.ResponsePagination;

@Service
public class BusinessUnitLocalService {

    @Autowired
    BusinessUnitLocalRepository businessUnitLocalRepository;

    @Autowired
    BusinessUnitLocalMapper businessUnitLocalMapper;

    public ResponsePagination<BusinessUnitLocalDto, BusinessUnitLocal> list(UUID businessUnitId, String name) {
        Pageable pageable = PageRequest.of(0, 10);

        if (name != null && !name.isEmpty()) {
            Page<BusinessUnitLocal> page = businessUnitLocalRepository
                    .findAllByBusinessUnitIdAndNameContainsIgnoreCase(pageable, businessUnitId, name);

            List<BusinessUnitLocalDto> businessUnitLocalDtos = page.getContent().stream()
                    .map(businessUnitLocalMapper::toDto).collect(Collectors.toList());

            return new ResponsePagination<>(businessUnitLocalDtos, page);
        }

        Page<BusinessUnitLocal> page = businessUnitLocalRepository.findAllByBusinessUnitId(pageable, businessUnitId);
        List<BusinessUnitLocalDto> businessUnitLocalDtos = page.getContent().stream()
                .map(businessUnitLocalMapper::toDto).collect(Collectors.toList());

        return new ResponsePagination<>(businessUnitLocalDtos, page);
    }

    public BusinessUnitLocalDto create(BusinessUnitLocalDto businessUnitLocalDto) {
        BusinessUnitLocal businessUnitLocal = businessUnitLocalMapper.toModel(businessUnitLocalDto);
        return businessUnitLocalMapper.toDto(businessUnitLocalRepository.save(businessUnitLocal));
    }

    public void delete(UUID id) {
        businessUnitLocalRepository.deleteById(id);
    }
}
