package com.cognizant.testing.mockito;

public class AdvancedCollaborators {
    public interface DemoRepository {
        String getData();
    }

    public interface RestClient {
        String getResponse();
    }

    public interface DemoFileReader {
        String read();
    }

    public interface DemoFileWriter {
        void write(String content);
    }

    public interface NetworkClient {
        String connect();
    }

    public static class RepositoryService {
        private final DemoRepository repository;

        public RepositoryService(DemoRepository repository) {
            this.repository = repository;
        }

        public String processData() {
            return "Processed " + repository.getData();
        }
    }

    public static class ApiService {
        private final RestClient restClient;

        public ApiService(RestClient restClient) {
            this.restClient = restClient;
        }

        public String fetchData() {
            return "Fetched " + restClient.getResponse();
        }
    }

    public static class FileService {
        private final DemoFileReader reader;
        private final DemoFileWriter writer;

        public FileService(DemoFileReader reader, DemoFileWriter writer) {
            this.reader = reader;
            this.writer = writer;
        }

        public String processFile() {
            String result = "Processed " + reader.read();
            writer.write(result);
            return result;
        }
    }

    public static class NetworkService {
        private final NetworkClient networkClient;

        public NetworkService(NetworkClient networkClient) {
            this.networkClient = networkClient;
        }

        public String connectToServer() {
            return "Connected to " + networkClient.connect();
        }
    }
}
