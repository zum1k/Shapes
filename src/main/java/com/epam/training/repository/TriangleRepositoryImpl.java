package com.epam.training.repository;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;
import com.epam.training.observer.Observer;
import com.epam.training.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TriangleRepositoryImpl implements Repository<Triangle> {

    private static final Logger logger = LogManager.getLogger(TriangleRepositoryImpl.class);
    private static final String DEFAULT_PATH = "Points.txt";

    private List<Observer> observers;
    private Map<Id, Triangle> triangleMap;

    public TriangleRepositoryImpl() {
    }

    @Override
    public void add(Triangle triangle) {
        Id id = triangle.getId();
        triangleMap.put(id, triangle);

    }

    @Override
    public void remove(Triangle triangle) {
        Id id = triangle.getId();
        triangleMap.remove(id);

    }

    @Override
    public void update(Triangle triangle) {
        Id id = triangle.getId();
        triangleMap.replace(id, triangle);

    }

    @Override
    public List<Triangle> sort(Comparator<Triangle> triangleComparator) {
        List<Triangle> triangles = new ArrayList<>(triangleMap.values());
        triangles.sort(triangleComparator);
        return triangles;

    }

    @Override
    public List<Triangle> query(Specification specification) {
        return null;
    }


}


