package com.jj.creative.domain.businessUnit;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, UUID> {
    List<BusinessUnit> findByNameContainsIgnoreCase(String name);
}
