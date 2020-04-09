package com.epam.training.factory.mapper;


import com.epam.training.entity.Point;

public class PointMapper {
    public Point mapPoint(String x, String y) {
        return new Point(Integer.parseInt(x), Integer.parseInt(y));
    }
}
