package io.spring.microservice.persistence.services;

import io.spring.microservice.models.CustomerDto;
import io.spring.microservice.persistence.entities.Customer;
import io.spring.microservice.persistence.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSimpleReadWorks() {
        Customer customer = new Customer("Customer", "One");
        customerRepository.save(customer);

        CustomerDto result = customerService.findAll().get(0);
        assertEquals("Customer", result.getFirstName());
    }

    @Test
    public void testSimpleFindByNameWorks() {
        Customer customer = new Customer("Customer", "One");
        customerRepository.save(customer);

        CustomerDto result = customerService.findByLastName("One").get(0);
        assertEquals("Customer", result.getFirstName());
    }

}