package com.jj.creative.business;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jj.creative.domain.businessUnit.BusinessUnitRepository;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

@SpringBootTest
public class BusinessTest {
    @Autowired
    BusinessUnitRepository businessUnitRepository;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void shouldFindAllBusinessUnit() {
        get("/api/business-unit").then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("business-unit.json"));
    }

}
