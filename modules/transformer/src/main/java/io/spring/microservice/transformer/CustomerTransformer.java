package io.spring.microservice.transformer;

import io.spring.microservice.entities.Customer;
import io.spring.microservice.models.CustomerDto;

public class CustomerTransformer implements Transformer<Customer, CustomerDto> {

    @Override
    public CustomerDto toDto(Customer entity) {
        return new CustomerDto(entity.getFirstName(), entity.getLastName());
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        return new Customer(dto.firstName(), dto.lastName());
    }
}
