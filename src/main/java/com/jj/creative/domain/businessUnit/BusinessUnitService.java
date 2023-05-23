package com.jj.creative.domain.businessUnit;

import java.util.UUID;

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

    public ResponsePagination<BusinessUnit> findAll(String name) {
        Pageable pageable = PageRequest.of(0, 10);

        if (name != null && !name.isEmpty()) {
            return new ResponsePagination<>(businessUnitRepository.findByNameContainsIgnoreCase(pageable, name));
        }

        return new ResponsePagination<>(businessUnitRepository.findAll(pageable));
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
