package com.cognizant.testing.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.cognizant.testing.mockito.AdvancedCollaborators.ApiService;
import com.cognizant.testing.mockito.AdvancedCollaborators.DemoFileReader;
import com.cognizant.testing.mockito.AdvancedCollaborators.DemoFileWriter;
import com.cognizant.testing.mockito.AdvancedCollaborators.DemoRepository;
import com.cognizant.testing.mockito.AdvancedCollaborators.NetworkClient;
import com.cognizant.testing.mockito.AdvancedCollaborators.NetworkService;
import com.cognizant.testing.mockito.AdvancedCollaborators.RepositoryService;
import com.cognizant.testing.mockito.AdvancedCollaborators.RestClient;
import com.cognizant.testing.mockito.AdvancedCollaborators.FileService;
import org.junit.jupiter.api.Test;

class MockitoAdvancedTest {
    @Test
    void shouldMockDatabaseRepository() {
        DemoRepository repository = mock(DemoRepository.class);
        when(repository.getData()).thenReturn("Mock Data");
        RepositoryService service = new RepositoryService(repository);
        assertEquals("Processed Mock Data", service.processData());
    }

    @Test
    void shouldMockRestClient() {
        RestClient restClient = mock(RestClient.class);
        when(restClient.getResponse()).thenReturn("Mock Response");
        ApiService service = new ApiService(restClient);
        assertEquals("Fetched Mock Response", service.fetchData());
    }

    @Test
    void shouldMockFileIo() {
        DemoFileReader reader = mock(DemoFileReader.class);
        DemoFileWriter writer = mock(DemoFileWriter.class);
        when(reader.read()).thenReturn("Mock File Content");
        FileService service = new FileService(reader, writer);
        assertEquals("Processed Mock File Content", service.processFile());
        verify(writer).write("Processed Mock File Content");
    }

    @Test
    void shouldMockNetworkInteraction() {
        NetworkClient networkClient = mock(NetworkClient.class);
        when(networkClient.connect()).thenReturn("Mock Connection");
        NetworkService service = new NetworkService(networkClient);
        assertEquals("Connected to Mock Connection", service.connectToServer());
    }

    @Test
    void shouldMockMultipleReturnValues() {
        DemoRepository repository = mock(DemoRepository.class);
        when(repository.getData()).thenReturn("First Mock Data").thenReturn("Second Mock Data");
        RepositoryService service = new RepositoryService(repository);
        assertEquals("Processed First Mock Data", service.processData());
        assertEquals("Processed Second Mock Data", service.processData());
    }
}
