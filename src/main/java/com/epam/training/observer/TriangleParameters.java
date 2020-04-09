package com.epam.training.observer;

class TriangleParameters {
    private double Area;
    private double Perimeter;

    TriangleParameters(double area, double perimeter) {
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
