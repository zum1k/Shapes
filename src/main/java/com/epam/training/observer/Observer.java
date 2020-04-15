package com.epam.training.observer;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;


public interface Observer {
     void update(Triangle triangle);
}
