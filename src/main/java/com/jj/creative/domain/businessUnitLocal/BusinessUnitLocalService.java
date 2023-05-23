package com.jj.creative.domain.businessUnitLocal;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jj.creative.utils.pagination.ResponsePagination;

@Service
public class BusinessUnitLocalService {

    @Autowired
    BusinessUnitLocalRepository businessUnitLocalRepository;

    public ResponsePagination<BusinessUnitLocal> list(UUID businessUnitId, String name) {
        Pageable pageable = PageRequest.of(0, 10);

        if (name != null && !name.isEmpty()) {
            return new ResponsePagination<>(businessUnitLocalRepository
                    .findAllByBusinessUnitIdAndNameContainsIgnoreCase(pageable, businessUnitId, name));
        }

        return new ResponsePagination<>(businessUnitLocalRepository.findAllByBusinessUnitId(pageable, businessUnitId));
    }

    public BusinessUnitLocal create(BusinessUnitLocal businessUnitLocal) {
        return businessUnitLocalRepository.save(businessUnitLocal);
    }
}
