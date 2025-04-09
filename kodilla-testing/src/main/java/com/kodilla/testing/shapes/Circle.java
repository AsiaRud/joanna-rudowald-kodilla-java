package com.kodilla.testing.shapes;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getShapeName (){
        return "Circle";
    }

    public double getField(){
        return 100;

    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Circle circle)) return false;

        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Circle (" +
                "radius = " + radius +
                ")";
    }
}
