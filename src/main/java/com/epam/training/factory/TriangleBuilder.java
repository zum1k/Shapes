package com.epam.training.factory;

import com.epam.training.factory.mapper.PointMapper;
import com.epam.training.factory.mapper.TriangleMapper;
import com.epam.training.factory.validator.TriangleValidatorImpl;
import com.epam.training.entity.Point;
import com.epam.training.entity.Triangle;


import java.util.List;

public class TriangleBuilder {
    private static final int STRING_INDEX_X = 0;
    private static final int STRING_INDEX_Y = 1;
    private static final String SPACE_DELINATOR = " ";

    public List<Triangle> buildTriangles(List<String> strings){
        List<Triangle> triangles = null;
        for (String s: strings) {
            String[]coordinates = s.split(SPACE_DELINATOR);

            PointMapper pointMapper = new PointMapper();
            Point a = pointMapper.mapPoint(coordinates[STRING_INDEX_X], coordinates[STRING_INDEX_Y]);
            Point b = pointMapper.mapPoint(coordinates[STRING_INDEX_X+2], coordinates[STRING_INDEX_Y+2]);
            Point c = pointMapper.mapPoint(coordinates[STRING_INDEX_X+4], coordinates[STRING_INDEX_Y+4]);

            TriangleValidatorImpl triangleValidator = new TriangleValidatorImpl(a,b,c);

            if(triangleValidator.isTriangle()){
                TriangleMapper triangleMapper = new TriangleMapper();
                triangles.add(triangleMapper.mapTriangle(a,b,c));
            }
        }
        return triangles;
    }
}
