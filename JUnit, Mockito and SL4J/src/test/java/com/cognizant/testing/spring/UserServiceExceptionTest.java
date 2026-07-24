package com.cognizant.testing.spring;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class UserServiceExceptionTest {
    @Test
    void shouldThrowWhenRequiredUserIsMissing() {
        UserRepository repository = mock(UserRepository.class);
        when(repository.findById(44L)).thenReturn(Optional.empty());
        UserService service = new UserService(repository);
        assertThrows(NoSuchElementException.class, () -> service.getRequiredUserById(44L));
    }
}
