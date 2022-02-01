package ru.academits.balyshen.shape;

public class Circle implements Shape{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getWidth() {
        return 2 * r;
    }

    public double getHeight() {
        return 2 * r;
    }

    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    public double getPerimeter() {
        return 2 * r * Math.PI;
    }
}
