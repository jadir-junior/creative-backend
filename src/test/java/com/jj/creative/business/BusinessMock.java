package com.jj.creative.business;

import java.util.ArrayList;
import java.util.List;

import com.jj.creative.domain.businessUnit.BusinessUnit;

public class BusinessMock {

    public static List<BusinessUnit> getBusinessUnits() {
        List<BusinessUnit> businessUnits = new ArrayList<>();

        businessUnits.add(new BusinessUnit("Fcamara"));
        businessUnits.add(new BusinessUnit("Bolovo"));

        return businessUnits;
    }
}
