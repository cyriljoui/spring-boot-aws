package com.cyriljoui.spring.poc.springbootaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({@PropertySource(value = "application-dev.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "application-dev-local.properties", ignoreResourceNotFound = true)})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
