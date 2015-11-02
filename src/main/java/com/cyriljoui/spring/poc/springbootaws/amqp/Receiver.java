package com.cyriljoui.spring.poc.springbootaws.amqp;

import com.cyriljoui.spring.poc.springbootaws.model.Customer;
import com.cyriljoui.spring.poc.springbootaws.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    private AtomicInteger countDown = new AtomicInteger();

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void receiveMessage(Customer customer) {
        log.info("Received <{}>", customer);
        customerRepository.save(customer);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDown.incrementAndGet();
    }

    public AtomicInteger getCountDown() {
        return countDown;
    }
}
