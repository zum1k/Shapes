package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;
import com.epam.training.service.impl.TriangleAction;

public class TrianglesByPerimetersBetweenSpecification implements Specification<Triangle> {
    private final TriangleAction triangleAction = new TriangleAction();
    private final double perimeter1;
    private final double perimeter2;
    public TrianglesByPerimetersBetweenSpecification(double perimeter1, double perimeter2){
        this.perimeter1 = perimeter1;
        this.perimeter2 = perimeter2;
    }
    @Override
    public boolean isSpecified(Triangle triangle) {
        double currentPerimeter = triangleAction.calcArea(triangle);
        boolean flag1 = Double.compare(currentPerimeter, perimeter1) > 0;
        boolean flag2 = Double.compare(perimeter2, currentPerimeter) > 0;
        return flag1 && flag2;
    }
}
