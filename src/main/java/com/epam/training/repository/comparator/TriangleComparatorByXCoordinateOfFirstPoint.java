package com.epam.training.repository.comparator;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;

import java.util.Comparator;

public class TriangleComparatorByXCoordinateOfFirstPoint implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        Point pointAt1 = t1.getPointA();
        Point pointAt2 = t2.getPointA();
        int t1X = pointAt1.getX();
        int t2X = pointAt2.getX();
        return Integer.compare(t1X, t2X);
    }
}
