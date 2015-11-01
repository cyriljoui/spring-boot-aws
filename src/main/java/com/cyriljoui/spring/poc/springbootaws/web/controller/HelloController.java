package com.cyriljoui.spring.poc.springbootaws.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello world from Spring Boot (on AWS). System properties: " + System.getProperties();
    }
}
