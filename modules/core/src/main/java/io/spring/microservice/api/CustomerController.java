package io.spring.microservice.api;

import io.spring.microservice.models.CustomerDto;
import io.spring.microservice.persistence.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers() {
        return customerService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCustomer(@Valid @RequestBody CustomerDto customer) {
        customerService.insert(customer);
    }

    @DeleteMapping
    @RequestMapping(path = "/deleteById/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @DeleteMapping
    @RequestMapping(path = "/deleteByLastName/{name}")
    public void deleteCustomerByLastName(@PathVariable(name = "name") String lastName) {
        customerService.deleteCustomerByLastName(lastName);
    }

}
