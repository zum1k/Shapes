package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;

public class TrianglesInRadiusSpecification implements Specification<Triangle> {
    private final double radius;
    public TrianglesInRadiusSpecification(double radius){
        this.radius = radius;
    }
    @Override
    public boolean isSpecified(Triangle triangle) {
        Point a = triangle.getPointA();
        Point b = triangle.getPointB();
        Point c = triangle.getPointC();
        double radiusA = calcRadius(a);
        if(radius > radiusA){
            return true;
        }
        double radiusB = calcRadius(b);
        if(radius > radiusB) {
            return true;
        }
        double radiusC = calcRadius(c);
        return radius > radiusC;
    }
    private double calcRadius(Point p){
        double x = p.getX();
        double y = p.getY();
        return Math.hypot(x, y);
    }
}
