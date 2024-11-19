package org.example.adapterlayerpoc.apicaller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiCaller {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, Object> callApi(String method, String url, Map<String, Object> data) throws Exception {
        String json = mapper.writeValueAsString(data);
        HttpRequest request;

        if ("POST".equalsIgnoreCase(method)) {
            request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        } else if ("PUT".equalsIgnoreCase(method)) {
            request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        } else if ("GET".equalsIgnoreCase(method)) {
            String getUrl = url + "?" + jsonToQueryParams(data);
            request = HttpRequest.newBuilder()
                    .uri(new URI(getUrl))
                    .GET()
                    .build();
        } else {
            throw new UnsupportedOperationException("HTTP method not supported: " + method);
        }

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response.body(), Map.class);
    }

    private static String jsonToQueryParams(Map<String, Object> data) {
        return data.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .reduce((a, b) -> a + "&" + b)
                .orElse("");
    }
}
