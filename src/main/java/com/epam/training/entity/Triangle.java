package com.epam.training.entity;


import java.util.Objects;

public class Triangle {

    private Id id;
    private Point pointA;
    private Point pointB;
    private Point pointC;

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
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }


    public Triangle() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
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
        return new String(new StringBuffer().append(this.getClass()).append(" ")
                .append(id).append(" [")
                .append("Point A: ").append(pointA.toString()).append(", ")
                .append("Point B: ").append(pointB.toString()).append(", ")
                .append("Point C: ").append(pointC.toString()).append("  ]"));

    }
}
