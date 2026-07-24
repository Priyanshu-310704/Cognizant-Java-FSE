package com.cognizant.testing.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class RepositoryServiceMockTest {
    @Test
    void shouldMockRepositoryDependencyInServiceTest() {
        UserRepository repository = mock(UserRepository.class);
        when(repository.findById(8L)).thenReturn(Optional.of(new User(8L, "Repository Mock", "repo@example.com")));

        UserService service = new UserService(repository);

        assertEquals("Repository Mock", service.getRequiredUserById(8L).getName());
    }
}
