package ru.academits.balyshen.shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return (int) Math.round(shape1.getPerimeter() - shape2.getPerimeter());
    }
}

