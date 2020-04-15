package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrianglesInRadiusSpecificationTest {
    private final double radius = 7;
    private Specification<Triangle> specification = new TrianglesInRadiusSpecification(radius);

    private final Point POINT_A = new Point(0, 0);
    private final Point POINT_B = new Point(3, 0);
    private final Point POINT_C = new Point(0, 4);
    private final Triangle TRIANGLE1 = new Triangle(POINT_A, POINT_B, POINT_C);

    private final Point POINT_D = new Point(10, 10);
    private final Point POINT_E = new Point(7, 12);
    private final Point POINT_F = new Point(20, 15);
    private final Triangle TRIANGLE2 = new Triangle(POINT_D, POINT_E, POINT_F);

    @Test
    public void testIsSpecifiedRadius_Seven_Greater_Triangle1_True() {
        //when
        boolean result = specification.isSpecified(TRIANGLE1);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsSpecifiedRadius_Seven_Greater_Triangle2_False() {
        //when
        boolean result = specification.isSpecified(TRIANGLE2);
        //then
        Assert.assertFalse(result);
    }
}