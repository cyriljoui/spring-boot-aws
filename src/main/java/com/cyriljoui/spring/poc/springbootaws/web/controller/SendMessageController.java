package com.cyriljoui.spring.poc.springbootaws.web.controller;

import com.cyriljoui.spring.poc.springbootaws.amqp.Receiver;
import com.cyriljoui.spring.poc.springbootaws.config.RabbitMQConfig;
import com.cyriljoui.spring.poc.springbootaws.model.Customer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Receiver receiver;

    @RequestMapping("/send")
    @ResponseBody
    public String sendMessage() {
        Customer customer = new Customer();
        customer.setFirstname("Cyril" + receiver.getCountDown());
        customer.setLastname(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMQConfig.queueName, customer);
        return "OK - count: " + receiver.getCountDown();
    }
}
