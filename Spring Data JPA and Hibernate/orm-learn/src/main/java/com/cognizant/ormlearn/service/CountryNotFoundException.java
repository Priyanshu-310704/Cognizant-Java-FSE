package com.cognizant.ormlearn.service;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String code) {
        super("Country not found for code: " + code);
    }
}
