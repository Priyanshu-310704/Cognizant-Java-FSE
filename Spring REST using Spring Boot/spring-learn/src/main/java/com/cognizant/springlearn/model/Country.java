package com.cognizant.springlearn.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull(message = "Country code is required")
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotNull(message = "Country name is required")
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode");
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
