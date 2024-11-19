package org.example.adapterlayerpoc.config;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ApiMappingConfig {
    private List<ApiMapping> apiMappings;

    @Data
    public static class ApiMapping {
        private String apiName;
        private Map<String, String> inputToTargetMapping;
        private Map<String, List<String>> nestedMappings;
        private String endpoint;
        private String method;
    }
}