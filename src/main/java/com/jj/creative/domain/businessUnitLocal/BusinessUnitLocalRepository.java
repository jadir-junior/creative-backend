package com.jj.creative.domain.businessUnitLocal;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessUnitLocalRepository extends JpaRepository<BusinessUnitLocal, UUID> {

    Page<BusinessUnitLocal> findAllByBusinessUnitIdAndNameContainsIgnoreCase(Pageable pageable, UUID id, String name);

    Page<BusinessUnitLocal> findAllByBusinessUnitId(Pageable pageable, UUID id);

}
