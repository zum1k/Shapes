package com.epam.training.repository.comparator;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;

import java.util.Comparator;

public class TriangleComparatorByID implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        Id id1 = t1.getId();
        Id id2 = t2.getId();
        long id1Value = id1.getId();
        long id2Value = id2.getId();
        return Long.compare(id1Value, id2Value);
    }
}
