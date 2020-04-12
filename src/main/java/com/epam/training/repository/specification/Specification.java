package com.epam.training.repository.specification;

import com.epam.training.entity.Triangle;


public interface Specification<T> {
    boolean specified(T t);
}
