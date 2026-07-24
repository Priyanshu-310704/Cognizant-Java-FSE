package com.cognizant.testing.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class MockitoBasicTest {
    @Test
    void shouldMockAndStubExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        assertEquals("Mock Data", service.fetchData());
    }

    @Test
    void shouldVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    void shouldUseArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getDataById(eq("A101"))).thenReturn("Student Data");
        MyService service = new MyService(mockApi);
        assertEquals("Student Data", service.fetchDataById("A101"));
        verify(mockApi).getDataById(eq("A101"));
    }

    @Test
    void shouldHandleVoidMethods() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.publish("payload");
        verify(mockApi).sendData("payload");
    }

    @Test
    void shouldReturnMultipleValues() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");
        MyService service = new MyService(mockApi);
        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    void shouldVerifyInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        service.publish("payload");
        InOrder order = inOrder(mockApi);
        order.verify(mockApi).getData();
        order.verify(mockApi).sendData("payload");
    }

    @Test
    void shouldHandleVoidMethodException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new IllegalStateException("Remote clear failed")).when(mockApi).clear();
        MyService service = new MyService(mockApi);
        assertThrows(IllegalStateException.class, service::clearRemoteData);
    }
}
