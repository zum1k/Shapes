package com.epam.training.repository.specification;

import com.epam.training.entity.Triangle;

public class TriangleSpecificationByAreaRange  implements TriangleSpecification {
    @Override
    public boolean specified(Triangle triangle) {
        return false;
    }
}
