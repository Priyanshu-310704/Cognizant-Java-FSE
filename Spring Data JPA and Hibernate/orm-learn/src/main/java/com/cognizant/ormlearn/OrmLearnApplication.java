package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.ProductSearchCriteria;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.quiz.Attempt;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.ProductSearchService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    @Bean
    CommandLineRunner runExercises(
            CountryService countryService,
            StockService stockService,
            EmployeeService employeeService,
            DepartmentService departmentService,
            SkillService skillService,
            AttemptService attemptService,
            ProductSearchService productSearchService) {
        return args -> {
            testCountries(countryService);
            testStocks(stockService);
            testPayroll(employeeService, departmentService, skillService);
            testQueries(employeeService, attemptService);
            testCriteria(productSearchService);
        };
    }

    private static void testCountries(CountryService countryService) {
        LOGGER.info("Start country exercises");
        LOGGER.debug("All countries: {}", countryService.getAllCountries());
        LOGGER.debug("Find IN: {}", countryService.findCountryByCode("IN"));
        countryService.addCountry(new Country("JP", "Japan"));
        countryService.updateCountry("JP", "Japan Updated");
        LOGGER.debug("Search containing ou: {}", countryService.searchByName("ou"));
        LOGGER.debug("Countries starting Z: {}", countryService.findByNameStartingWith("Z"));
        countryService.deleteCountry("JP");
        LOGGER.info("End country exercises");
    }

    private static void testStocks(StockService stockService) {
        LOGGER.info("Start stock query method exercises");
        LOGGER.debug("Facebook Sept 2019: {}", stockService.findByCodeAndMonth("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30)));
        LOGGER.debug("Google close greater than 1250: {}", stockService.findByCodeAndCloseGreaterThan("GOOGL", 1250.00));
        LOGGER.debug("Top 3 by volume: {}", stockService.findTop3ByVolume());
        LOGGER.debug("Netflix lowest close: {}", stockService.findLowest3ByCode("NFLX"));
        LOGGER.info("End stock query method exercises");
    }

    private static void testPayroll(EmployeeService employeeService, DepartmentService departmentService, SkillService skillService) {
        LOGGER.info("Start payroll mapping exercises");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());

        Employee newEmployee = new Employee("David Green", 72000, true, LocalDate.of(1994, 1, 5));
        newEmployee.setDepartment(departmentService.get(1));
        employeeService.save(newEmployee);

        Skill sql = skillService.get(3);
        newEmployee.getSkillList().add(sql);
        employeeService.save(newEmployee);

        LOGGER.debug("Department employees: {}", departmentService.get(1).getEmployeeList());
        LOGGER.info("End payroll mapping exercises");
    }

    private static void testQueries(EmployeeService employeeService, AttemptService attemptService) {
        LOGGER.info("Start HQL, JPQL, native query exercises");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        Attempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("Attempt by {} on {}", attempt.getUser().getUserName(), attempt.getAttemptedDate());
        attempt.getAttemptQuestions().forEach(aq -> {
            LOGGER.debug("Question: {}", aq.getQuestion().getQuestionText());
            aq.getAttemptOptions().forEach(ao -> LOGGER.debug("{} {} {}", ao.getOption().getOptionText(), aq.getQuestion().getScore(), ao.isSelectedAnswer()));
        });
        LOGGER.debug("Average salary department 1: {}", employeeService.getAverageSalary(1));
        LOGGER.debug("All employees native: {}", employeeService.getAllEmployeesNative());
        LOGGER.info("End HQL, JPQL, native query exercises");
    }

    private static void testCriteria(ProductSearchService productSearchService) {
        LOGGER.info("Start criteria query exercise");
        ProductSearchCriteria criteria = new ProductSearchCriteria("laptop", 4, null, "16GB", null, "Windows", null, null);
        LOGGER.debug("Criteria products: {}", productSearchService.search(criteria));
        LOGGER.info("End criteria query exercise");
    }
}
