package com.epam.training.repository.comparator;

import com.epam.training.entity.Triangle;
import com.epam.training.service.TriangleAction;

import java.math.BigDecimal;
import java.util.Comparator;

public class TriangleComparatorByPerimeter implements Comparator<Triangle> {
    private final TriangleAction triangleAction = new TriangleAction();
    @Override
    public int compare(Triangle t1, Triangle t2) {
        BigDecimal perimeter1 = triangleAction.calcPerimeter(t1);
        BigDecimal perimeter2 = triangleAction.calcPerimeter(t2);
        return perimeter1.compareTo(perimeter2);
    }
}
