package com.epam.training.observer.impl;

import com.epam.training.entity.Id;
import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;
import com.epam.training.observer.Observer;
import com.epam.training.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleObserverTest {
    private final Point POINT_A = new Point(0, 0);
    private final Point POINT_B = new Point(3, 0);
    private final Point POINT_C = new Point(0, 4);

    private final Point POINT_D = new Point(6, 0);
    private final Point POINT_E = new Point(0, 8);

    private final Id id = new Id(0L);
    private static final double DELTA = 0.01;
    private final Triangle TRIANGLE1 = new Triangle(POINT_A, POINT_B, POINT_C);
    private final Observer observer = new TriangleObserver();

    {
        TRIANGLE1.registerObserver(observer);
        TRIANGLE1.setId(id);
    }

    private final Warehouse warehouse = Warehouse.getInstance();

    @Test
    public void testUpdate_Perimeter_And_Area_After_Update_True() {
        //given
        Observer observer = new TriangleObserver();
        TRIANGLE1.registerObserver(observer);
        double perimeter = 24;
        double area = 24;
        //when
        TRIANGLE1.setPointB(POINT_D);
        TRIANGLE1.setPointC(POINT_E);
        double resultPerimeter = warehouse.getParameters(id).getPerimeter();
        double resultArea = warehouse.getParameters(id).getArea();
        //then
        Assert.assertEquals(perimeter, resultPerimeter, DELTA);
        Assert.assertEquals(area, resultArea, DELTA);
    }
}