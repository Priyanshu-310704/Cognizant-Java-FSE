package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) {
        return countryRepository.findById(countryCode).orElseThrow(() -> new CountryNotFoundException(countryCode));
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) {
        Country country = findCountryByCode(code);
        country.setName(name);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> searchByName(String text) {
        return countryRepository.searchByName(text);
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameStartingWith(String prefix) {
        return countryRepository.findByNameStartingWithIgnoreCaseOrderByNameAsc(prefix);
    }
}
