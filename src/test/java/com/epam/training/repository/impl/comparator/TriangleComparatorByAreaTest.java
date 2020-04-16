package com.epam.training.repository.impl.comparator;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public class TriangleComparatorByAreaTest {
    private final Comparator<Triangle> comparator = new TriangleComparatorByArea();
    private final Point pointA = new Point(0, 0);
    private final Point pointB = new Point(2, 0);
    private final Point pointC = new Point(0, 4);
    private final Point pointD = new Point(0, 2);
    private final Triangle TRIANGLE1 = new Triangle(pointA, pointB, pointC);
    private final Triangle TRIANGLE2 = new Triangle(pointA, pointB, pointD);


    @Test
    public void testCompareByAreas_Four_Two_Plus() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE2);
        //then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompareByAreas_Two_Four_Minus() {
        //when
        int result = comparator.compare(TRIANGLE2, TRIANGLE1);
        //then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testCompareByAreas_Four_Four_Zero() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE1);
        //then
        Assert.assertEquals(0, result);
    }
}