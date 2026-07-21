package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        LOGGER.debug("Inside CountryController Constructor.");
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("Start");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            LOGGER.info("End");
            return country;
        }
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.info("End");
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.getCountry(code);
        LOGGER.info("End");
        return country;
    }

    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start");
        LOGGER.debug("Country: {}", country);
        Country added = countryService.addCountry(country);
        LOGGER.info("End");
        return added;
    }

    @DeleteMapping("/countries/{code}")
    public void deleteCountry(@PathVariable String code) {
        LOGGER.info("Start");
        countryService.deleteCountry(code);
        LOGGER.info("End");
    }
}
