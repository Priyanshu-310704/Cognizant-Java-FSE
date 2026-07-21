package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main");
        displayDate();
        displayCountry();
        displayCountries();
    }

    private static void displayDate() {
        LOGGER.info("Start displayDate");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml")) {
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            LOGGER.debug("Date: {}", format.format(new Date()));
        }
        LOGGER.info("End displayDate");
    }

    private static void displayCountry() {
        LOGGER.info("Start displayCountry");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            Country country = context.getBean("country", Country.class);
            Country anotherCountry = context.getBean("country", Country.class);
            LOGGER.debug("Country: {}", country);
            LOGGER.debug("Prototype scope creates different objects: {}", country != anotherCountry);
        }
        LOGGER.info("End displayCountry");
    }

    @SuppressWarnings("unchecked")
    private static void displayCountries() {
        LOGGER.info("Start displayCountries");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
            List<Country> countries = (List<Country>) ((ApplicationContext) context).getBean("countryList");
            LOGGER.debug("Countries: {}", countries);
        }
        LOGGER.info("End displayCountries");
    }
}
