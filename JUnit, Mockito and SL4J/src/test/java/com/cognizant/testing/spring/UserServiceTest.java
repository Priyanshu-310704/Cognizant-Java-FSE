package com.cognizant.testing.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    @Test
    void shouldFetchUserFromRepository() {
        UserRepository repository = mock(UserRepository.class);
        User user = new User(1L, "Anu", "anu@example.com");
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        UserService service = new UserService(repository);

        assertEquals("Anu", service.getUserById(1L).getName());
    }

    @Test
    void shouldReturnNullForMissingUser() {
        UserRepository repository = mock(UserRepository.class);
        when(repository.findById(99L)).thenReturn(Optional.empty());
        UserService service = new UserService(repository);
        assertNull(service.getUserById(99L));
    }
}
