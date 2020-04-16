package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;
import com.epam.training.service.impl.TriangleAction;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrianglesByAreaBetweenSpecificationTest {
    private final TriangleAction triangleAction = new TriangleAction();
    private final double area1 = 5;
    private final double area2 = 105;

    private final Point POINT_A = new Point(0, 0);
    private final Point POINT_B = new Point(4, 0);
    private final Point POINT_C = new Point(0, 5);
    private final Triangle TRIANGLE1 = new Triangle(POINT_A, POINT_B, POINT_C);

    private final Point POINT_D = new Point(0, 0);
    private final Point POINT_E = new Point(10, 0);
    private final Point POINT_F = new Point(0, 40);
    private final Triangle TRIANGLE2 = new Triangle(POINT_A, POINT_B, POINT_C);


    private final Specification<Triangle> specification = new TrianglesByAreaBetweenSpecification(5,105);

    @Test
    public void testIsSpecified_Ten_Between_Five_OneZeroFive_True() {
        //when
        boolean result = specification.isSpecified(TRIANGLE1);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSpecified_Ten_Between_Five_OneZeroFive_False() {
        //when
        boolean result = specification.isSpecified(TRIANGLE1);
        //then
        Assert.assertTrue(result);
    }
}