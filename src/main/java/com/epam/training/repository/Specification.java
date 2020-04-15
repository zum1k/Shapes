package com.epam.training.repository;

public interface Specification<T> {
    boolean isSpecified(T t);
}
