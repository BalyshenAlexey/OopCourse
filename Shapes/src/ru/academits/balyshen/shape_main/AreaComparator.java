package ru.academits.balyshen.shape_main;

import ru.academits.balyshen.shape.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return (int) Math.round(shape1.getArea() - shape2.getArea());
    }
}
