package com.jj.creative.domain.businessUnit;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, UUID> {
    Page<BusinessUnit> findByNameContainsIgnoreCase(Pageable pageable, String name);
}
