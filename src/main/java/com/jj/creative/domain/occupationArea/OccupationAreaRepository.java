package com.jj.creative.domain.occupationArea;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationAreaRepository extends JpaRepository<OccupationArea, UUID> {

    Page<OccupationArea> findAllByBusinessUnitLocalIdAndNameContainsIgnoreCase(Pageable pageable, UUID id, String name);

    Page<OccupationArea> findAllByBusinessUnitLocalId(Pageable pageable, UUID id);
}
