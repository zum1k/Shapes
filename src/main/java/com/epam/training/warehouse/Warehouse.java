package com.epam.training.warehouse;

import com.epam.training.entity.Id;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class Warehouse {
    private static final Logger LOGGER = LogManager.getLogger(Warehouse.class);

    private static final Warehouse INSTANCE = new Warehouse();
    private Map<Id, TriangleParameters> triangleMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        LOGGER.info("Warehouse object returned" + INSTANCE);
        return INSTANCE;
    }

    public Map<Id, TriangleParameters> getTriangleMap() {
        return triangleMap;
    }

    public void putParameters(Id id, TriangleParameters parameters) {
        triangleMap.put(id, parameters);
        LOGGER.info("TriangleParameters object added " + id + "  " + parameters);
    }

    public TriangleParameters getParameters(Id id) {
        LOGGER.info("Object returned " + id);
        return triangleMap.get(id);
    }
}
