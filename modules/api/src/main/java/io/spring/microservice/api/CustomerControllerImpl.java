package io.spring.microservice.api;

import io.spring.microservice.models.CustomerDto;
import io.spring.microservice.persistence.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Override
    public void insertCustomer(CustomerDto customer) {
        customerService.saveCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerService.deleteCustomer(id);
    }

    @Override
    public void deleteCustomerByLastName(String lastName) {
        customerService.deleteCustomerByLastName(lastName);
    }

}
