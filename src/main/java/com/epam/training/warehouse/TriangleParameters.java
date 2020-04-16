package com.epam.training.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleParameters {
    private static final Logger LOGGER = LogManager.getLogger(TriangleParameters.class);
    private double Area;
    private double Perimeter;

    public TriangleParameters(double area, double perimeter) {

        Area = area;
        Perimeter = perimeter;
    }

    public double getArea() {
        LOGGER.info("Area returned: " + Area);
        return Area;
    }

    public double getPerimeter() {
        LOGGER.info("Perimeter returned: " + Perimeter);
        return Perimeter;
    }
}
