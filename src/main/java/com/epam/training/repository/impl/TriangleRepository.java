package com.epam.training.repository.impl;

import com.epam.training.entity.Triangle;
import com.epam.training.repository.Repository;
import com.epam.training.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleRepository implements Repository<Triangle> {
    private static final TriangleRepository INSTANCE = new TriangleRepository();
    private static final Logger LOGGER = LogManager.getLogger(TriangleRepository.class);

    private List<Triangle> triangles = new ArrayList<>();

    private TriangleRepository() {
    }

    public static TriangleRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
        LOGGER.info("Triangle added: " + triangle);
    }

    @Override
    public void remove(Triangle triangle) {
        int num = (int) (triangle.getId().getId());
        triangles.remove(num);
        LOGGER.info("Triangle removed: "+triangle);
    }

    @Override
    public void update(Triangle triangle) {
        int id = (int) (triangle.getId().getId());
        triangles.set(id, triangle);
        LOGGER.info("Triangle updated: "+triangle);
    }

    @Override
    public List<Triangle> sort(Comparator<Triangle> comparator) {
        triangles.sort(comparator);
        LOGGER.info("Triangles sorted by"+comparator.getClass());
        return triangles;
    }

    @Override
    public List<Triangle> getAll() {
        LOGGER.info("Triangles returned.");
        return triangles;
    }

    @Override
    public List<Triangle> query(Specification<Triangle> specification) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (specification.isSpecified(triangle)) {
                result.add(triangle);
            }
        }
        LOGGER.info("Triangles quered by:" + specification.getClass());
        return result;
    }
}


