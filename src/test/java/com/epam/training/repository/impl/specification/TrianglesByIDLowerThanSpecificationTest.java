package com.epam.training.repository.impl.specification;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;
import com.epam.training.repository.Specification;
import org.junit.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TrianglesByIDLowerThanSpecificationTest {

    private final Id id1 = new Id(5L);
    private final Triangle TRIANGLE1 = new Triangle();

    private final Id id2 = new Id(20L);
    private final Triangle TRIANGLE2 = new Triangle();
    {
        TRIANGLE1.setId(id1);
        TRIANGLE2.setId(id2);
    }
    private final Id specifiedID = new Id(10L);
    private final Specification<Triangle> specification = new TrianglesByIDLowerThanSpecification(specifiedID);

    @Test
    public void testIsSpecifiedByID_Ten_Five_True() {
        //when
        boolean result = specification.isSpecified(TRIANGLE1);
        //then
        Assert.assertTrue(result);
    }
    @Test
    public void testIsSpecifiedByID_Ten_Twenty_False() {
        //when
        boolean result = specification.isSpecified(TRIANGLE2);
        //then
        Assert.assertFalse(result);
    }
}