package com.epam.training.repository;

import com.epam.training.entity.Triangle;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T t);

    void remove(T t);

    void update(T t);

    List<T> getAll();

    List<Triangle> sort(Comparator<T> comparator);

    List<T> query(Specification<T> specification);
}
