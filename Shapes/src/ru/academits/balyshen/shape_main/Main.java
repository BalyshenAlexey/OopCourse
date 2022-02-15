package ru.academits.balyshen.shape_main;

import ru.academits.balyshen.shape.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondLargestPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());

        double maxPerimeter = shapes[shapes.length - 1].getPerimeter();

        for (int i = shapes.length - 2; i > 0; i--) {
            if (shapes[i].getPerimeter() < maxPerimeter) {
                return shapes[i];
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(4),
                new Triangle(1, 2, 4, 5, 7, 8),
                new Rectangle(3, 7),
                new Square(11),
                new Circle(7),
                new Rectangle(28, 7),
                new Rectangle(5, 7),
                new Triangle(-1, 2, 6, 6, 8, -6),
                new Circle(2),
                new Square(2)
        };

        System.out.println("Фигура с максимальной площадью: " + getMaxArea(shapes));
        System.out.println("Фигура со вторым по величине периметром: " + getSecondLargestPerimeter(shapes));
    }
}
