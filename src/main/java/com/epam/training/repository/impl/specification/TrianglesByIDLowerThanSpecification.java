package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;

public class TrianglesByIDLowerThanSpecification implements Specification<Triangle> {
    private final Id id;
    public TrianglesByIDLowerThanSpecification(Id id){
        this.id = id;
    }
    @Override
    public boolean isSpecified(Triangle triangle) {
        long currentID = triangle.getId().getId();
        long specifiedID = id.getId();
        return specifiedID > currentID;
    }
}
