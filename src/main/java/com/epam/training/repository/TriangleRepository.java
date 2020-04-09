package com.epam.training.repository;




import com.epam.training.entity.Triangle;
import com.epam.training.repository.specification.TriangleSpecification;

import java.util.Comparator;
import java.util.List;

public interface TriangleRepository {
    void add(Triangle triangle);
    void remove(Triangle triangle);
    void update(Triangle triangle);

    List<Triangle> sort(Comparator<Triangle> triangleComparator);
    List<TriangleSpecification> query(TriangleSpecification specification);
}
