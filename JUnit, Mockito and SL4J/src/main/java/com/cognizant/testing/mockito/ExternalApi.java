package com.cognizant.testing.mockito;

public interface ExternalApi {
    String getData();
    String getDataById(String id);
    void sendData(String data);
    void clear();
}
