package ru.academits.balyshen.shape;

public class Triangle implements Shape{
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double EPSILON = 1.0e-10;

        if ((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1) >= -EPSILON) {
            System.out.println("Введенные Вами точки лежат на одной прямой!");
        } else {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }
    }

    public double getWidth() {
        double max = Math.max(x1, Math.max(x2, x3));
        double min = Math.min(x1, Math.min(x2, x3));

        return max - min;
    }

    public double getHeight() {
        double max = Math.max(y1, Math.max(y2, y3));
        double min = Math.min(y1, Math.min(y2, y3));

        return max - min;
    }

    public double getArea() {
        double side1Length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y3 - y1, 2));
        double side2Length = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3Length = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        double semiPerimeter = (side1Length + side2Length + side3Length) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - side1Length) * (semiPerimeter - side2Length) * (semiPerimeter - side3Length));
    }

    public double getPerimeter() {
        double side1Length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y3 - y1, 2));
        double side2Length = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3Length = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        return side1Length + side2Length + side3Length;
    }
}
