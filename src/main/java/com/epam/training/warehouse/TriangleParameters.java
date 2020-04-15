package com.epam.training.warehouse;

public class TriangleParameters {
    private double Area;
    private double Perimeter;

    public TriangleParameters(double area, double perimeter) {
        Area = area;
        Perimeter = perimeter;
    }

    public double getArea() {
        return Area;
    }

    public double getPerimeter() {
        return Perimeter;
    }
}
