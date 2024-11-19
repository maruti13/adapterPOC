package org.example.adapterlayerpoc.service.transformation;

import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.Map;

@Data
public class TransformedRequest {
    private String url;
    private HttpMethod method;
    private Object body;
    private Class<?> responseType;
    private Map<String, String> headers;
    private Map<String, String> queryParams;

}
