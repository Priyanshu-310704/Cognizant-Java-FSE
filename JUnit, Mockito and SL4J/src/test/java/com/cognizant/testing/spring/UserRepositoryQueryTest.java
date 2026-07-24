package com.cognizant.testing.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryQueryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserByEmail() {
        userRepository.save(new User(null, "Nila", "nila@example.com"));

        var result = userRepository.findByEmail("nila@example.com");

        assertTrue(result.isPresent());
        assertEquals("Nila", result.get().getName());
    }
}
