package com.epam.training.factory.validator;

import com.epam.training.entity.Point;

public class TriangleValidatorImpl implements TriangleValidator {
    private Point a;
    private Point b;
    private Point c;

    public TriangleValidatorImpl(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean isTriangle() {
        boolean flagX = a.getX() == b.getX() && b.getX() == c.getX();
        boolean flagY = a.getY() == b.getY() && b.getY() == c.getY();

        if(a.equals(b) || a.equals(c) || b.equals(c) || flagX || flagY ){
            return false;
        }

        double x1MinusX3 = a.getX() - c.getX();
        double y2MinusY3 = b.getY() - c.getY();
        double x2MinusX3 = b.getX() - c.getX();
        double y1MinusY3 = a.getY() - c.getY();

        return x1MinusX3/y1MinusY3 == x2MinusX3/y2MinusY3;
    }
}
