package com.kodilla.testing.shapes;

public class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;
    private double hight;

    public Triangle(double sideA, double sideB, double sideC, double hight) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.hight = hight;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        return 0;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Triangle triangle)) return false;

        return Double.compare(sideA, triangle.sideA) == 0 && Double.compare(sideB, triangle.sideB) == 0 && Double.compare(hight, triangle.hight) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(sideA);
        result = 31 * result + Double.hashCode(sideB);
        result = 31 * result + Double.hashCode(hight);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", hight=" + hight +
                '}';
    }
}
