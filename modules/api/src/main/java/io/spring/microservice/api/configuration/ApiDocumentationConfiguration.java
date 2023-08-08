package io.spring.microservice.api.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = false)
public class ApiDocumentationConfiguration {

    @Bean
    public OpenAPI openApi(@Value("${application.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info().title("Spring Template Service")
                        .description("A Spring Template for Microservices"))
                .components(new Components())
                .addServersItem(new Server().url("http://localhost:8080").description("Local development"));
    }

}
