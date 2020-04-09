package com.epam.training.repository.specification;

import com.epam.training.entity.Triangle;

public class TriangleSpecificationByRangeFromAxis implements TriangleSpecification {
    @Override
    public boolean specified(Triangle triangle) {
        return false;
    }
}
