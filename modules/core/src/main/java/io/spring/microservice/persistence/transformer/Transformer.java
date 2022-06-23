package io.spring.microservice.persistence.transformer;

interface Transformer <T, R> {

    R toDto(T entity);
    T toEntity(R dto);

}
