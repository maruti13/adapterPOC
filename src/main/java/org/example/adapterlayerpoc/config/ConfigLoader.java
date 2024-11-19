package org.example.adapterlayerpoc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ConfigLoader {
    public static ApiMappingConfig loadConfig(String configPath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(configPath), ApiMappingConfig.class);
    }
}