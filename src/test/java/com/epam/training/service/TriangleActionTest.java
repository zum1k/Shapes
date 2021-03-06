package com.epam.training.service;

import com.epam.training.entity.Id;
import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.service.impl.TriangleAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleActionTest {
    //given
    private final static Point POINT_A = new Point(0, 0);
    private final static Point POINT_B = new Point(3, 0);
    private final static Point POINT_C = new Point(0, 4);
    private final static Id ID = new Id(1L);
    private final static Triangle TRIANGLE = new Triangle(POINT_A, POINT_B, POINT_C);
    private static final double DELTA = 0.01;

    private final TriangleAction triangleAction = new TriangleAction();


    @Test
    public void testCalcArea() {
        //when
        double result = triangleAction.calcArea(TRIANGLE);
        //then
        Assert.assertEquals(6.0, result, DELTA);
    }

    @Test
    public void testCalcPerimeter_True() {
        //given
        double perimeter = 12.0;
        //when
        double result = triangleAction.calcPerimeter(TRIANGLE);
        //then
        Assert.assertEquals(perimeter, result, DELTA);
    }

    @Test
    public void testCalcSide_True() {
        //when
        double result = triangleAction.calcSide(POINT_A, POINT_B);
        //then
        Assert.assertEquals(3, result, DELTA);
    }

    @Test
    public void testIsEquilateral_False() {
        //when
        boolean result = triangleAction.isEquilateral(TRIANGLE);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsIsosceles_False() {
        //when
        boolean result = triangleAction.isIsosceles(TRIANGLE);
        //then
        Assert.assertFalse(result);
    }

    @Test
    public void testIsRectangular_True() {
        //when
        boolean result = triangleAction.isRectangular(TRIANGLE);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsObtuse_False() {
        //when
        boolean result = triangleAction.isObtuse(TRIANGLE);
        //then
        Assert.assertFalse(result);
    }
}