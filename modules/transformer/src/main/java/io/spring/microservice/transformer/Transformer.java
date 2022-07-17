package io.spring.microservice.transformer;

interface Transformer <T, R> {

    R toDto(T entity);
    T toEntity(R dto);

}
