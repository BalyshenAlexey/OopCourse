package ru.academits.balyshen.shape;

public class Rectangle implements Shape{
    private double side1Length;
    private double side2Length;

    public Rectangle(double side1Length, double side2Length) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
    }

    public double getWidth() {
        return side1Length;
    }

    public double getHeight() {
        return side2Length;
    }

    public double getArea() {
        return side1Length * side2Length;
    }

    public double getPerimeter() {
        return 2 * side1Length + 2 * side2Length;
    }
}
