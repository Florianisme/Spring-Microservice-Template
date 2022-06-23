package io.spring.microservice.persistence.transformer;

import io.spring.microservice.models.CustomerDto;
import io.spring.microservice.persistence.entities.Customer;

public class CustomerTransformer implements Transformer<Customer, CustomerDto> {

    @Override
    public CustomerDto toDto(Customer entity) {
        return new CustomerDto(entity.getFirstName(), entity.getLastName());
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        return new Customer(dto.getFirstName(), dto.getLastName());
    }
}
