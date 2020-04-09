package com.epam.training.service;

import com.epam.training.entity.Triangle;

import java.math.BigDecimal;

public interface AreaCalculator {
    BigDecimal calcArea(Triangle triangle);
}
