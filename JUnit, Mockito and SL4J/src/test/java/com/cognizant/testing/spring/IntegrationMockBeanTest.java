package com.cognizant.testing.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationMockBeanTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldMockServiceDependencyInIntegrationTest() throws Exception {
        when(userService.getRequiredUserById(9L)).thenReturn(new User(9L, "Integration Mock", "integration@example.com"));

        mockMvc.perform(get("/users/9"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Integration Mock"));
    }
}
