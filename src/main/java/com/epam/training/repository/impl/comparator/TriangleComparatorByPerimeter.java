package com.epam.training.repository.impl.comparator;

import com.epam.training.entity.Triangle;
import com.epam.training.service.impl.TriangleAction;

import java.util.Comparator;

public class TriangleComparatorByPerimeter implements Comparator<Triangle> {
    private final TriangleAction triangleAction = new TriangleAction();

    @Override
    public int compare(Triangle t1, Triangle t2) {
        double perimeter1 = triangleAction.calcPerimeter(t1);
        double perimeter2 = triangleAction.calcPerimeter(t2);
        return Double.compare(perimeter1, perimeter2);
    }
}
