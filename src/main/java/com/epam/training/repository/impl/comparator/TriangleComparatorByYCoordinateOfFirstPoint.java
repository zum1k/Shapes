package com.epam.training.repository.impl.comparator;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;

import java.util.Comparator;

public class TriangleComparatorByYCoordinateOfFirstPoint implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        Point pointAt1 = t1.getPointA();
        Point pointAt2 = t2.getPointA();
        int t1Y = pointAt1.getY();
        int t2Y = pointAt2.getY();
        return Integer.compare(t1Y, t2Y);
    }
}
