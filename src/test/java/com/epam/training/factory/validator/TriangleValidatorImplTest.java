package com.epam.training.factory.validator;

import com.epam.training.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleValidatorImplTest {
    private final Point pointA = new Point(0, 0);
    private final Point pointB = new Point(3, 0);
    private final Point pointC = new Point(0, 4);
    private final Point pointD = new Point(0, 10);

    private final TriangleValidatorImpl triangleValidatorABC = new TriangleValidatorImpl(pointA, pointB, pointC);
    private final TriangleValidatorImpl triangleValidatorACD = new TriangleValidatorImpl(pointA, pointC, pointD);
    @Test
    public void testIsTriangle_TriangleABC_True() {
        //when
        boolean result = triangleValidatorABC.isTriangle();
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsTriangle_TriangleACD_False() {
        //when
        boolean result = triangleValidatorACD.isTriangle();
        //then
        Assert.assertFalse(result);
    }
}