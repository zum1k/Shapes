package com.epam.training.repository;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;
import com.epam.training.exception.RepositoryException;
import com.epam.training.factory.TriangleBuilder;
import com.epam.training.factory.filemanager.FileManagerImpl;
import com.epam.training.factory.parser.TriangleParser;
import com.epam.training.observer.Observer;
import com.epam.training.repository.specification.TriangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TriangleRepositoryImpl implements TriangleRepository {
    private static final Logger logger = LogManager.getLogger(TriangleRepositoryImpl.class);
    private static final String DEFAULT_PATH = "Points.txt";

    private Observer observer;
    private Map<Id, Triangle> triangleMap = new HashMap<>() {
    };

    public TriangleRepositoryImpl(Observer observer) {
        List<Triangle> triangles;
        triangles = loadData();
        for (Triangle triangle : triangles) {
            Id id = triangle.getId();
            this.triangleMap.put(id, triangle);
        }
        this.observer = observer;
    }

    @Override
    public void add(Triangle triangle) {
        Id id = triangle.getId();
        triangleMap.put(id, triangle);
        observer.add(triangle);
    }

    @Override
    public void remove(Triangle triangle) {
        Id id = triangle.getId();
        triangleMap.remove(id);
        observer.remove(id);
    }

    @Override
    public void update(Triangle triangle) {
        Id id = triangle.getId();
        triangleMap.replace(id, triangle);
        observer.update(triangle);
    }

    @Override
    public List<Triangle> sort(Comparator<Triangle> triangleComparator) {
        List<Triangle> triangles = new ArrayList<>(triangleMap.values());
        triangles.sort(triangleComparator);
        return triangles;

    }

    @Override
    public List<TriangleSpecification> query(TriangleSpecification specification) {
        return null;
    }

    private List<Triangle> loadData() {

        List<String> strings = new ArrayList<>();
        try {
            FileManagerImpl fileManager = new FileManagerImpl();
            TriangleParser triangleParser = new TriangleParser();

            strings = fileManager.readStrings(DEFAULT_PATH);
            strings = triangleParser.parseStrings(strings);
        } catch (RepositoryException e) {
            logger.error("Ошибка чтения");
            e.printStackTrace();
        }

        return new TriangleBuilder().buildTriangles(strings);

    }
}


