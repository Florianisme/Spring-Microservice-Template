package io.spring.microservice.persistence.services;

import io.spring.microservice.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.spring.microservice.models.CustomerDto;
import io.spring.microservice.persistence.repositories.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

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