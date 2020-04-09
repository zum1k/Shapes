package com.epam.training.service;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TriangleAction implements AreaCalculator, PerimeterCalculator, SideCalculator {
        @Override
    public BigDecimal calcArea(Triangle triangle) {
        BigDecimal p = getHalfPerimeter(triangle);
        BigDecimal pMinusA = p.add(getSideA(triangle).negate());
        BigDecimal pMinusB = p.add(getSideB(triangle).negate());
        BigDecimal pMinusC = p.add(getSideC(triangle).negate());
        return (p.multiply(pMinusA).multiply(pMinusB).multiply(pMinusC)).sqrt(new MathContext(5, RoundingMode.HALF_UP));
    }

    @Override
    public BigDecimal calcPerimeter(Triangle triangle) {
        BigDecimal sideA = getSideA(triangle);
        BigDecimal sideB = getSideB(triangle);
        BigDecimal sideC = getSideC(triangle);
        return sideA.add(sideB.add(sideC));
    }

    @Override
    public BigDecimal calcSide(Point a, Point b) {
        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();
        return new BigDecimal(Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }

    public boolean isEquilateral(Triangle triangle) {
        BigDecimal a = getSideA(triangle);
        BigDecimal b = getSideB(triangle);
        BigDecimal c = getSideC(triangle);
        return a.equals(b) && b.equals(c);
    }

    public boolean isIsosceles(Triangle triangle) {
        BigDecimal a = getSideA(triangle);
        BigDecimal b = getSideB(triangle);
        BigDecimal c = getSideC(triangle);
        return a.equals(b) || b.equals(c) || a.equals(c);
    }

    public boolean isRectangular(Triangle triangle) {
        BigDecimal a = getSideA(triangle);
        BigDecimal b = getSideB(triangle);
        BigDecimal c = getSideC(triangle);

        boolean flag1 = a.multiply(a).equals(b.multiply(b).add(c.multiply(c)));
        boolean flag2 = b.multiply(b).equals(a.multiply(a).add(c.multiply(c)));
        boolean flag3 = c.multiply(c).equals(b.multiply(b).add(a.multiply(a)));
        return flag1 || flag2 || flag3;
    }

    public boolean isObtuse(Triangle triangle) {
        BigDecimal a = getSideA(triangle);
        BigDecimal b = getSideB(triangle);
        BigDecimal c = getSideC(triangle);

        boolean flag1 = a.multiply(a).compareTo(b.multiply(b).add(c.multiply(c))) > 0;
        boolean flag2 = b.multiply(b).compareTo(a.multiply(a).add(c.multiply(c))) > 0;
        boolean flag3 = c.multiply(c).compareTo(b.multiply(b).add(a.multiply(a))) > 0;
        return flag1 || flag2 || flag3;

    }

    private BigDecimal getSideA(Triangle triangle) {
        return calcSide(triangle.getPointA(), triangle.getPointB());
    }

    private BigDecimal getSideB(Triangle triangle) {
        return calcSide(triangle.getPointB(), triangle.getPointC());

    }

    private BigDecimal getSideC(Triangle triangle) {
        return calcSide(triangle.getPointC(), triangle.getPointA());
    }

    private BigDecimal getHalfPerimeter(Triangle triangle) {
        return calcPerimeter(triangle).divide(new BigDecimal(5), RoundingMode.HALF_UP);
    }


}
