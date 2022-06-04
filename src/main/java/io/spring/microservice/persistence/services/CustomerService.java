package io.spring.microservice.persistence.services;

import io.spring.microservice.api.CustomerController;
import io.spring.microservice.models.CustomerDto;
import io.spring.microservice.persistence.entities.Customer;
import io.spring.microservice.persistence.repositories.CustomerRepository;
import io.spring.microservice.persistence.transformer.CustomerTransformer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(new CustomerTransformer()::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void insert(CustomerDto customer) {
        customerRepository.save(new CustomerTransformer().toEntity(customer));
    }

    @Transactional
    public void deleteCustomer(@NonNull Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No customer found for ID " + id);
        }
    }

    @Transactional
    public void deleteCustomerByLastName(String name) {
        List<Customer> customers = customerRepository.findByLastName(name);
        if (customers.isEmpty()) {
            throw new IllegalArgumentException("No Customer found for ID " + name);
        }
        for (Customer customer : customers) {
            LoggerFactory.getLogger(CustomerController.class).info("Deleting customer {} {}", customer.getFirstName(), customer.getLastName());
            deleteCustomer(customer.getId());
        }
    }

    @Transactional(readOnly = true)
    public List<CustomerDto> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName)
                .stream()
                .map(new CustomerTransformer()::toDto).collect(Collectors.toList());
    }
}
