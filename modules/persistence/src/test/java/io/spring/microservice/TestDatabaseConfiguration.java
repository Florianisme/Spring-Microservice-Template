package io.spring.microservice;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import io.spring.microservice.persistence.DatabaseConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration
public class TestDatabaseConfiguration extends DatabaseConfiguration {
}
