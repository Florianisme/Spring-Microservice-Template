package io.spring.microservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

public class CustomerDto {

    @JsonProperty
    @NotBlank
    private final String firstName;

    @JsonProperty
    @NotBlank
    private final String lastName;

    public CustomerDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
