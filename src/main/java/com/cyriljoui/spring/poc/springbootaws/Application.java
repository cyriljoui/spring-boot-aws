package com.cyriljoui.spring.poc.springbootaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableRdsInstance(databaseName = "ebdb", dbInstanceIdentifier = "aa4h8yjva50slh", username = "pocdbuser", password = "pocdbuser")
//@EnableContextCredentials(accessKey = "", secretKey = "")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
