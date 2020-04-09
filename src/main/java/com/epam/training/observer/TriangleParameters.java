package com.epam.training.observer;

import java.math.BigDecimal;

 class TriangleParameters {
    private BigDecimal Area;
    private BigDecimal Perimeter;

    TriangleParameters(BigDecimal area, BigDecimal perimeter) {
        Area = area;
        Perimeter = perimeter;
    }

     public BigDecimal getArea() {
         return Area;
     }

     public BigDecimal getPerimeter() {
         return Perimeter;
     }
 }
