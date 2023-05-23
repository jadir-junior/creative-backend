package com.jj.creative.domain.occupationArea;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jj.creative.utils.pagination.ResponsePagination;

@Service
public class OccupationAreaService {
    @Autowired
    OccupationAreaRepository occupationAreaRepository;

    public ResponsePagination<OccupationArea> list(UUID businessUnitLocalId, String name) {
        Pageable pageable = PageRequest.of(0, 10);

        if (name != null && !name.isEmpty()) {
            return new ResponsePagination<>(occupationAreaRepository
                    .findAllByBusinessUnitLocalIdAndNameContainsIgnoreCase(pageable, businessUnitLocalId, name));
        }

        return new ResponsePagination<>(occupationAreaRepository.findAll(pageable));
    }

    public OccupationArea create(OccupationArea occupationArea) {
        return occupationAreaRepository.save(occupationArea);
    }

}
