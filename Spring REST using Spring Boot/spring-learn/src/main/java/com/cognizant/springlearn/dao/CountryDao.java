package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
    private static final List<Country> COUNTRY_LIST = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public CountryDao() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            COUNTRY_LIST.clear();
            COUNTRY_LIST.addAll((List<Country>) context.getBean("countryList"));
        }
    }

    public List<Country> getAllCountries() {
        return COUNTRY_LIST;
    }

    public void addCountry(Country country) {
        COUNTRY_LIST.removeIf(existing -> existing.getCode().equalsIgnoreCase(country.getCode()));
        COUNTRY_LIST.add(country);
    }

    public void deleteCountry(String code) {
        COUNTRY_LIST.removeIf(country -> country.getCode().equalsIgnoreCase(code));
    }
}
