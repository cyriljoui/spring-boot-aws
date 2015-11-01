package com.cyriljoui.spring.poc.springbootaws.repository;

import com.cyriljoui.spring.poc.springbootaws.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
