package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    void testHello() throws Exception {
        mvc.perform(get("/hello")).andExpect(status().isOk());
    }

    @Test
    void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/country"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void testGetCountryByCode() throws Exception {
        mvc.perform(get("/countries/in").with(httpBasic("user", "pwd")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void testGetCountryException() throws Exception {
        mvc.perform(get("/countries/az").with(httpBasic("user", "pwd")))
                .andExpect(status().isNotFound())
                .andExpect(status().reason("Country not found"));
    }

    @Test
    void testCountryValidation() throws Exception {
        mvc.perform(post("/countries")
                        .with(httpBasic("user", "pwd"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"code\":\"I\",\"name\":\"India\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0]").value("Country code should be 2 characters"));
    }
}
