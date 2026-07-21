package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {
    private final CountryDao countryDao;

    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    @Transactional(readOnly = true)
    public Country getCountry(String code) {
        return getAllCountries().stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }

    @Transactional
    public Country addCountry(Country country) {
        countryDao.addCountry(country);
        return country;
    }

    @Transactional
    public void deleteCountry(String code) {
        getCountry(code);
        countryDao.deleteCountry(code);
    }
}
