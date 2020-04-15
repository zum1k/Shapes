package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;
import com.epam.training.service.impl.TriangleAction;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrianglesByPerimetersBetweenSpecificationTest {
    private final TriangleAction triangleAction = new TriangleAction();
    private final double perimeter1 = 5;
    private final double perimeter2 = 20;

    private final Point POINT_A = new Point(0, 0);
    private final Point POINT_B = new Point(3, 0);
    private final Point POINT_C = new Point(0, 4);
    private final Triangle TRIANGLE1 = new Triangle(POINT_A, POINT_B, POINT_C);

    private final Point POINT_D = new Point(0, 0);
    private final Point POINT_E = new Point(6, 0);
    private final Point POINT_F = new Point(0, 8);
    private final Triangle TRIANGLE2 = new Triangle(POINT_D, POINT_E, POINT_F);


    private Specification<Triangle> specification = new TrianglesByPerimetersBetweenSpecification(perimeter1,perimeter2);

    @Test
    public void testIsSpecifiedPerimeter_Twelve_Between_Five_Twenty_True() {
        //when
        boolean result = specification.isSpecified(TRIANGLE1);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSpecifiedPerimeter_TwentyFour_Between_Five_Twenty_False() {
        //when
        boolean result = specification.isSpecified(TRIANGLE2);
        //then
        Assert.assertFalse(result);
    }
}