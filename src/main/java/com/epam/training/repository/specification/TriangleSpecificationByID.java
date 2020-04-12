package com.epam.training.repository.specification;

import com.epam.training.entity.Triangle;

public class TriangleSpecificationByID implements Specification<Triangle> {
    @Override
    public boolean specified(Triangle triangle) {
        return false;
    }
}
