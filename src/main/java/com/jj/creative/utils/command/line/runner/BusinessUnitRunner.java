package com.jj.creative.utils.command.line.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.jj.creative.domain.businessUnit.BusinessUnit;
import com.jj.creative.domain.businessUnit.BusinessUnitRepository;
import com.jj.creative.domain.businessUnitLocal.BusinessUnitLocal;
import com.jj.creative.domain.businessUnitLocal.BusinessUnitLocalRepository;

@Component
public class BusinessUnitRunner implements CommandLineRunner {
    @Autowired
    BusinessUnitRepository businessUnitRepository;

    @Autowired
    BusinessUnitLocalRepository businessUnitLocalRepository;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run(String... args) throws Exception {
        // deleteBusiness();

        // createBusinessUnits();
        // createBusinessUnitLocals();
    }

    public void createBusinessUnits() {
        logger.info("Creating new business units...");

        List<BusinessUnit> businessUnits = new ArrayList<>();
        businessUnits.add(new BusinessUnit("Fcamara"));
        businessUnits.add(new BusinessUnit("Bolovo"));

        logger.info("Saving new business units...");
        businessUnitRepository.saveAll(businessUnits);
    }

    public void createBusinessUnitLocals() {
        logger.info("Creating new business unit locals...");
        Pageable pageable = PageRequest.of(0, 10);
        Page<BusinessUnit> page = businessUnitRepository.findByNameContainsIgnoreCase(pageable, "bolovo");

        UUID bolovoId = page.getContent().get(0).getId();

        List<BusinessUnitLocal> businessUnitLocals = new ArrayList<>();
        businessUnitLocals.add(new BusinessUnitLocal("Loja Pinheiros", bolovoId));
        businessUnitLocals.add(new BusinessUnitLocal("Escritório Fradique", bolovoId));

        logger.info("Saving new business unit locals...");
        businessUnitLocalRepository.saveAll(businessUnitLocals);
    }

    private void deleteBusiness() {
        logger.info("Deleting business units...");
        businessUnitRepository.deleteAll();

        logger.info("Deleting business unit locals...");
        businessUnitLocalRepository.deleteAll();
    }
}
