package com.epam.training.observer;

import com.epam.training.entity.Id;
import com.epam.training.entity.Triangle;


public interface Observer {
    public void update(Triangle triangle);

    public void remove(Id id);

    public void add(Triangle triangle);
}
