package com.epam.training.service;

import com.epam.training.entity.Point;


import java.math.BigDecimal;

public interface SideCalculator {
    double calcSide(Point a, Point b);
}
