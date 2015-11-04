package com.cyriljoui.spring.poc.springbootaws.repository;

import com.cyriljoui.spring.poc.springbootaws.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastname(@Param("lastname") String lastname);

    List<Customer> findByFirstname(@Param("firstname") String firstname);

}
