package com.epam.training.entity;

import com.epam.training.observer.Observable;
import com.epam.training.observer.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Triangle implements Observable {
    private static final Logger LOGGER = LogManager.getLogger(Triangle.class);
    private Id id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private final List<Observer> observers = new ArrayList<>();

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle() {
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
        LOGGER.info("Observers notified. Parameters changed. " + this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Objects.equals(id, triangle.id) &&
                Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getClass()).append(" ")
                .append(id).append(" [")
                .append("Point A: ").append(pointA.toString()).append(", ")
                .append("Point B: ").append(pointB.toString()).append(", ")
                .append("Point C: ").append(pointC.toString()).append("  ]").toString();

    }
}
