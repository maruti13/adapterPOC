package org.example.adapterlayerpoc.service.apicaller;

import org.example.adapterlayerpoc.service.transformation.TransformedRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class HttpClientService {

    private final RestTemplate restTemplate;

    public HttpClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object executeRequest(TransformedRequest request) {
        // Build the URL with query parameters
        String urlWithParams = buildUrlWithQueryParams(request.getUrl(), request.getQueryParams());

        // Create HTTP headers
        HttpHeaders headers = new HttpHeaders();

        /*if (request.getHeaders() != null) {
            request.getHeaders().forEach(headers::add);
        }*/

        // Create the request entity
        HttpEntity<Object> httpEntity = new HttpEntity<>(request.getBody(), headers);
        System.out.println(request.getBody());
        // Execute the HTTP request
        ResponseEntity<?> responseEntity;
        try {
            responseEntity = restTemplate.exchange(
                    urlWithParams,
                    request.getMethod(),
                    httpEntity,
                    request.getResponseType()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error executing HTTP request: " + e.getMessage(), e);
        }

        // Return the response body
        return responseEntity.getBody();
    }

    private String buildUrlWithQueryParams(String url, Map<String, String> queryParams) {
        if (queryParams == null || queryParams.isEmpty()) {
            return url;
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        queryParams.forEach(builder::queryParam);
        return builder.toUriString();
    }
}
