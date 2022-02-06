package ru.academits.balyshen.shape;

public class Rectangle implements Shape {
    private double side1Length;
    private double side2Length;

    public Rectangle(double side1Length, double side2Length) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
    }

    @Override
    public double getWidth() {
        return side1Length;
    }

    @Override
    public double getHeight() {
        return side2Length;
    }

    @Override
    public double getArea() {
        return side1Length * side2Length;
    }

    @Override
    public double getPerimeter() {
        return 2 * side1Length + 2 * side2Length;
    }

    @Override
    public String toString() {
        return "Прямоугольник. Длина - " + getHeight() + ", ширина - " + getWidth() + ", площадь - " + getArea() + ", периметр - " + getPerimeter() + ".";
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(side1Length);
        hash = prime * hash + Double.hashCode(side2Length);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Rectangle r = (Rectangle) o;

        return side1Length == r.side1Length && side2Length == r.side2Length;
    }
}
