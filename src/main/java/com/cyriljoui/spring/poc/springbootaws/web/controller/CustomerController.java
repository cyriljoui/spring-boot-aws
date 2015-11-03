package com.cyriljoui.spring.poc.springbootaws.web.controller;

import com.cyriljoui.spring.poc.springbootaws.model.Customer;
import com.cyriljoui.spring.poc.springbootaws.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CustomerController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/allcustomers")
    @ResponseBody
    public List<Customer> all() throws NoSuchAlgorithmException {
        long startTime = System.currentTimeMillis();
        Iterable<Customer> all = customerRepository.findAll();
        List<Customer> customers = StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        customers.forEach((customer) -> messageDigest.digest((customer.getFirstname() + customer.getLastname()).getBytes()));
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("all customers execution time {}", (executionTime));
        return customers;
    }
}
