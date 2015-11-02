package com.cyriljoui.spring.poc.springbootaws.web.controller;

import com.cyriljoui.spring.poc.springbootaws.model.Customer;
import com.cyriljoui.spring.poc.springbootaws.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/allcustomers")
    @ResponseBody
    public List<Customer> all() {
        Iterable<Customer> all = customerRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
    }
}
