package io.spring.microservice.api;

import io.spring.microservice.api.configuration.ApiTags;
import io.spring.microservice.models.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/customers")
public interface CustomerController {

    @Operation(summary = "Retrieve all customers", tags = ApiTags.CUSTOMER)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CustomerDto> getAllCustomers();

    @Operation(summary = "Store a new customer", tags = ApiTags.CUSTOMER)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    void insertCustomer(@Validated @RequestBody CustomerDto customer);

    @Operation(summary = "Remove a customer by their ID", tags = ApiTags.CUSTOMER)
    @DeleteMapping(path = "/deleteById/{id}")
    void deleteCustomerById(@PathVariable Long id);

    @Operation(summary = "Remove a customer by their last name", tags = ApiTags.CUSTOMER)
    @DeleteMapping(path = "/deleteByLastName/{name}")
    void deleteCustomerByLastName(@PathVariable(name = "name") String lastName);

}
