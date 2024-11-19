package org.example.adapterlayerpoc.service;

import org.example.adapterlayerpoc.service.adapter.TransformationFactory;
import org.example.adapterlayerpoc.service.apicaller.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.example.adapterlayerpoc.service.transformation.PartyCreationTransformation;
import org.example.adapterlayerpoc.service.transformation.Transformation;
import org.example.adapterlayerpoc.service.transformation.TransformedRequest;

import java.util.Map;

/*
"Create a service class named PartyService in Spring Boot. The class should have a method processApiRequest that takes in an API name, path params, query params, headers, and the body of the request. It should call an adapter to handle the API-specific logic (i.e., request transformation, API call, and response transformation). Handle exceptions for HTTP errors and return appropriate messages in the response entity."
 */
@Service
@SuppressWarnings("unchecked")
public class PartyMasterService {

    @Autowired
    private final HttpClientService httpClientService;

    @Autowired
    private final TransformationFactory trasformationFactory;

    public PartyMasterService(HttpClientService httpClientService, TransformationFactory trasformationFactory) {
        this.httpClientService = httpClientService;
        this.trasformationFactory = trasformationFactory;
    }

    public ResponseEntity<Object> processApiRequest(
            String apiName,
            Map<String, String> pathParams,
            Map<String, String> queryParams,
            Map<String, String> headers,
            Object apiRequest
    ) {
        try {
            //make use of Factory pattern to get the Transformation object during runtime
            //Transformation trasformer = new PartyCreationTransformation();
            Transformation trasformer = trasformationFactory.getTransformation(apiName);

            // Transform request using generic transformation
            TransformedRequest transformedRequest = (TransformedRequest) trasformer.transformRequest(apiRequest, pathParams, queryParams, headers);

            // Call the external API
            Object response = httpClientService.executeRequest(transformedRequest);

            // Transform response
            Object resp = trasformer.transformResponse(response);

            return ResponseEntity.ok(resp);

        } catch (HttpClientErrorException e) {
            String errorMessage = e.getStatusCode().is4xxClientError() ? e.getMessage() : "Unknown error";
            return ResponseEntity.status(e.getStatusCode()).body(Map.of("message", errorMessage));
        }
    }

}
