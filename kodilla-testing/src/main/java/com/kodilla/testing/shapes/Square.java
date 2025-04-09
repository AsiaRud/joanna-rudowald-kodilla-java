package com.kodilla.testing.shapes;

public class Square implements Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return side * side;
    }


    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Square square)) return false;

        return Double.compare(side, square.side) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(side);
    }

    @Override
    public String toString() {
        return "Square (" +
                "side = " + side +
                " )";
    }
}


