package com.epam.training.factory.mapper;

import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;



public class TriangleMapper {
    public Triangle mapTriangle(Point a, Point b, Point c) {
        return new Triangle(a, b , c);
    }
}
