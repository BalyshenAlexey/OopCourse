package ru.academits.balyshen.shape_main;

import ru.academits.balyshen.shape.*;

import java.util.Arrays;

public class Main {
    public static int findMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());

        return shapes.length - 1;
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Circle(4),
                new Triangle(1, 2, 4, 5, 7, 8),
                new Rectangle(3, 7),
                new Square(14),
                new Circle(7),
                new Rectangle(28, 7),
                new Rectangle(5, 7),
                new Triangle(-1, 2, 6, 6, 8, -6),
                new Circle(2),
                new Square(2)
        };

        System.out.println(Arrays.toString(shapes));

        System.out.println(shapes[findMaxArea(shapes)]);
    }
}
