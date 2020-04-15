package com.epam.training.factory.validator;

import com.epam.training.entity.Point;
import com.epam.training.service.impl.TriangleAction;

public class TriangleValidatorImpl implements TriangleValidator {
    private final TriangleAction triangleAction = new TriangleAction();
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

        if (a == null || b == null || c == null) {
            return false;
        }
        double ab = triangleAction.calcSide(a, b);
        double bc = triangleAction.calcSide(b, c);
        double ca = triangleAction.calcSide(c, a);

        return ab < bc + ca && bc < ab + ca && ca < ab + bc;
    }
}
