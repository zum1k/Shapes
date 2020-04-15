package com.epam.training.service.impl;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.service.AreaCalculator;
import com.epam.training.service.PerimeterCalculator;
import com.epam.training.service.SideCalculator;

public class TriangleAction implements AreaCalculator, PerimeterCalculator, SideCalculator {
    @Override
    public double calcArea(Triangle triangle) {
        double p = getHalfPerimeter(triangle);
        double pMinusA = p - getSideA(triangle);
        double pMinusB = p - getSideB(triangle);
        double pMinusC = p - getSideC(triangle);
        return Math.sqrt(p * pMinusA * pMinusB * pMinusC);
    }

    @Override
    public double calcPerimeter(Triangle triangle) {
        double sideA = getSideA(triangle);
        double sideB = getSideB(triangle);
        double sideC = getSideC(triangle);
        return sideA + sideB + sideC;
    }

    @Override
    public double calcSide(Point a, Point b) {
        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public boolean isEquilateral(Triangle triangle) {
        double a = getSideA(triangle);
        double b = getSideB(triangle);
        double c = getSideC(triangle);
        return a == b && b == c;
    }

    public boolean isIsosceles(Triangle triangle) {
        double a = getSideA(triangle);
        double b = getSideB(triangle);
        double c = getSideC(triangle);
        return a == b || b == c || a == c;
    }

    public boolean isRectangular(Triangle triangle) {
        double a = getSideA(triangle);
        double b = getSideB(triangle);
        double c = getSideC(triangle);

        boolean isAHypotenuse = a * a == (b * b + c * c);
        boolean isBHypotenuse = b * b == (a * a + c * c);
        boolean isCHypotenuse = c * c == (a * a + b * b);
        return isAHypotenuse || isBHypotenuse || isCHypotenuse;
    }

    public boolean isObtuse(Triangle triangle) {
        double a = getSideA(triangle);
        double b = getSideB(triangle);
        double c = getSideC(triangle);

        boolean compareAWithBC = a * a > (b * b + c * c);
        boolean compareBWithAC = b * b > (a * a + c * c);
        boolean compareCWithAC = c * c > (a * a + b * b);
        return compareAWithBC || compareBWithAC || compareCWithAC;

    }

    private double getSideA(Triangle triangle) {
        return calcSide(triangle.getPointA(), triangle.getPointB());
    }

    private double getSideB(Triangle triangle) {
        return calcSide(triangle.getPointB(), triangle.getPointC());

    }

    private double getSideC(Triangle triangle) {
        return calcSide(triangle.getPointC(), triangle.getPointA());
    }

    private double getHalfPerimeter(Triangle triangle) {
        return calcPerimeter(triangle) / 2.0;
    }


}
