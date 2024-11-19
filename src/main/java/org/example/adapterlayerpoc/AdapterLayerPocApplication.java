package org.example.adapterlayerpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "org.example",exclude = {DataSourceAutoConfiguration.class})
public class AdapterLayerPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdapterLayerPocApplication.class, args);
    }

}
