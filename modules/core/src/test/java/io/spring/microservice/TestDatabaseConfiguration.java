package io.spring.microservice;

import io.spring.microservice.persistence.DatabaseConfiguration;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration
public class TestDatabaseConfiguration extends DatabaseConfiguration {
}
