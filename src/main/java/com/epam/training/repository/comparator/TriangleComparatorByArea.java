package com.epam.training.repository.comparator;

import com.epam.training.entity.Triangle;
import com.epam.training.service.TriangleAction;

import java.math.BigDecimal;
import java.util.Comparator;

public class TriangleComparatorByArea implements Comparator<Triangle> {
    private final TriangleAction triangleAction = new TriangleAction();
    @Override
    public int compare(Triangle t1, Triangle t2) {
        BigDecimal area1 = triangleAction.calcArea(t1);
        BigDecimal area2 = triangleAction.calcArea(t2);
        return area1.compareTo(area2);
    }
}
