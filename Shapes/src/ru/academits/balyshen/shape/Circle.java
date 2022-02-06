package ru.academits.balyshen.shape;

public class Circle implements Shape{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getWidth() {
        return 2 * r;
    }

    @Override
    public double getHeight() {
        return 2 * r;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * r * Math.PI;
    }

    @Override
    public String toString() {
        return "Круг. Радиус - " + r
                + ", диаметр - " + getWidth()
                + ", площадь - " + getArea()
                + ", периметр - " + getPerimeter() + ".";
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(r);
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

        Circle c = (Circle) o;

        return r == c.r;
    }
}
