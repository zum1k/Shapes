package com.epam.training.repository.impl.comparator;

import com.epam.training.entity.Id;
import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public class TriangleComparatorByIDTest {
    private final Comparator<Triangle> comparator = new TriangleComparatorByID();
    private final Point pointA = new Point(0, 0);
    private final Point pointB = new Point(2, 0);
    private final Point pointC = new Point(0, 4);
    private final Point pointD = new Point(0, 2);
    private final Id id1 = new Id(0L);
    private final Id id2 = new Id(1L);
    private final Triangle TRIANGLE1 = new Triangle(pointA, pointB, pointC);
    private final Triangle TRIANGLE2 = new Triangle(pointA, pointB, pointD);

    {
        TRIANGLE1.setId(id1);
        TRIANGLE2.setId(id2);
    }

    @Test
    public void testCompareByIDs_Zero_One_Minus() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE2);
        //then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testCompareByIDs_One_Zero_Plus() {
        //when
        int result = comparator.compare(TRIANGLE2, TRIANGLE1);
        //then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompareByIDs_One_One_Zero() {
        //when
        int result = comparator.compare(TRIANGLE2, TRIANGLE2);
        //then
        Assert.assertEquals(0, result);
    }
}