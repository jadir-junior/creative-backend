package com.jj.creative.domain.businessUnit;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jj.creative.domain.businessUnit.dto.BusinessUnitDto;
import com.jj.creative.domain.businessUnit.dto.BusinessUnitMapper;
import com.jj.creative.utils.pagination.ResponsePagination;

@Service
public class BusinessUnitService {
    private final BusinessUnitRepository businessUnitRepository;

    private final BusinessUnitMapper businessUnitMapper;

    BusinessUnitService(BusinessUnitRepository businessUnitRepository, BusinessUnitMapper businessUnitMapper) {
        this.businessUnitRepository = businessUnitRepository;
        this.businessUnitMapper = businessUnitMapper;
    }

    public ResponsePagination<BusinessUnitDto, BusinessUnit> findAll(String name) {
        Pageable pageable = PageRequest.of(0, 10);

        if (name != null && !name.isEmpty()) {
            Page<BusinessUnit> page = businessUnitRepository.findByNameContainsIgnoreCase(pageable, name);
            List<BusinessUnit> businessUnit = page.getContent();
            List<BusinessUnitDto> businessUnitDtos = businessUnit.stream().map(businessUnitMapper::toDTO)
                    .collect(Collectors.toList());
            return new ResponsePagination<>(businessUnitDtos, page);
        }

        Page<BusinessUnit> page = businessUnitRepository.findAll(pageable);
        List<BusinessUnit> businessUnit = page.getContent();
        List<BusinessUnitDto> businessUnitDtos = businessUnit.stream().map(businessUnitMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponsePagination<>(businessUnitDtos, page);
    }

    public BusinessUnitDto create(BusinessUnit businessUnit) {
        return businessUnitMapper.toDTO(businessUnitRepository.save(businessUnit));
    }

    public BusinessUnitDto findById(UUID id) {
        return businessUnitRepository.findById(id).map(businessUnitMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Could not find"));
    }

    public void delete(UUID id) {
        businessUnitRepository.deleteById(id);
    }
}
