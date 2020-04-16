package com.epam.training.repository.impl.comparator;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public class TriangleComparatorByPerimeterTest {
    private final Comparator<Triangle> comparator = new TriangleComparatorByPerimeter();
    private final Point POINT_A = new Point(0, 0);
    private final Point POINT_B = new Point(6, 0);
    private final Point POINT_C = new Point(0, 8);
    private final Point POINT_D = new Point(3, 0);
    private final Point POINT_E = new Point(0, 4);
    private final Triangle TRIANGLE1 = new Triangle(POINT_A, POINT_B, POINT_C);
    private final Triangle TRIANGLE2 = new Triangle(POINT_A, POINT_E, POINT_D);

    @Test
    public void testCompareByPerimeters_TwoFour_OneFire_Plus() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE2);
        //then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompareByPerimeters_OneFire_TwoFour_Minus() {
        //when
        int result = comparator.compare(TRIANGLE2, TRIANGLE1);
        //then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testCompareByPerimeters_TwoFour_TwoFour_Zero() {
        //when
        int result = comparator.compare(TRIANGLE1, TRIANGLE1);
        //then
        Assert.assertEquals(0, result);
    }
}