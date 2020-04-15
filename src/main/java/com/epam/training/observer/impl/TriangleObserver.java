package com.epam.training.observer.impl;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;

import com.epam.training.observer.Observer;
import com.epam.training.service.impl.TriangleAction;
import com.epam.training.warehouse.TriangleParameters;
import com.epam.training.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer {
    private static final Logger LOGGER = LogManager.getLogger(TriangleObserver.class);
    private final TriangleAction triangleAction = new TriangleAction();

    @Override
    public void update(Triangle triangle) {
        double area = triangleAction.calcArea(triangle);
        double perimeter = triangleAction.calcPerimeter(triangle);
        Id id = triangle.getId();
        Warehouse warehouse = Warehouse.getInstance();
        TriangleParameters triangleParameters = new TriangleParameters(area, perimeter);
        warehouse.putParameters(id, triangleParameters);
        LOGGER.info("Warehouse updated "+id + "  "+triangleParameters);
    }
}
