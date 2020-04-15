package com.epam.training.repository.impl.comparator;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.*;

public class TriangleComparatorByYCoordinateOfFirstPointTest {
    private final Comparator<Triangle> comparator = new TriangleComparatorByYCoordinateOfFirstPoint();
    private final Point POINT_A = new Point(0, 0);
    private final Point POINT_B = new Point(2, 0);
    private final Point POINT_C = new Point(0, 4);
    private final Point POINT_D = new Point(1, 1);
    private final Triangle TRIANGLE1 = new Triangle(POINT_A, POINT_B, POINT_C);
    private final Triangle TRIANGLE2 = new Triangle(POINT_D, POINT_B, POINT_C);

    @Test
    public void testCompareByYCors_Zero_One_Minus() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE2);
        //then
        Assert.assertEquals(-1, result);
    }


    @Test
    public void testCompareByYCors_One_Zero_Minus() {
        //when
        int result = comparator.compare(TRIANGLE2, TRIANGLE1);
        //then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompareByYCors_Zero_Zero_Zero() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE1);
        //then
        Assert.assertEquals(0, result);
    }
}