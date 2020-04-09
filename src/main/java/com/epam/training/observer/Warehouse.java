package com.epam.training.observer;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;
import com.epam.training.service.TriangleAction;

import java.util.Map;

public class Warehouse implements Observer {
    private final TriangleAction triangleAction = new TriangleAction();
    private Map<Id, TriangleParameters> triangleMap;

    public Warehouse(Map<Id, TriangleParameters> triangleMap) {
        this.triangleMap = triangleMap;
    }


    @Override
    public void update(Triangle triangle) {
        Id id = triangle.getId();
        TriangleParameters triangleParameters = calcTriangleParameters(triangle);
        triangleMap.replace(id, triangleParameters);
    }

    @Override
    public void remove(Id id) {
        triangleMap.remove(id);
    }

    @Override
    public void add(Triangle triangle) {
        Id id = triangle.getId();
        TriangleParameters triangleParameters = calcTriangleParameters(triangle);
        triangleMap.put(id, triangleParameters);
    }

    private TriangleParameters calcTriangleParameters(Triangle triangle) {
        double area = triangleAction.calcArea(triangle);
        double perimeter = triangleAction.calcPerimeter(triangle);
        return new TriangleParameters(area, perimeter);

    }
}
