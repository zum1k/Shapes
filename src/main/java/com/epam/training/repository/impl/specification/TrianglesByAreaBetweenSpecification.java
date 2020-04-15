package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;
import com.epam.training.service.impl.TriangleAction;

public class TrianglesByAreaBetweenSpecification implements Specification<Triangle> {
    private final TriangleAction triangleAction = new TriangleAction();
    private final double area1;
    private final double area2;
    public TrianglesByAreaBetweenSpecification(double area1, double area2){
        this.area1 = area1;
        this.area2 = area2;
    }
    @Override
    public boolean isSpecified(Triangle triangle) {
        double currentArea = triangleAction.calcArea(triangle);
        boolean flag1 = Double.compare(currentArea, area1) > 0;
        boolean flag2 = Double.compare(area2, currentArea) > 0;
        return flag1 && flag2;
    }
}
