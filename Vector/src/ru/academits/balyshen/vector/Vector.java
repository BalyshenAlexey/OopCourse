package ru.academits.balyshen.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorLength) {
        if (vectorLength <= 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + vectorLength + ". Введите значение больше 0.");
        }

        components = new double[vectorLength];
    }

    public Vector(Vector vector) {
        this(vector.components);
    }

    public Vector(double[] array) {
        components = new double[array.length];

        System.arraycopy(array, 0, components, 0, array.length);
    }

    public Vector(int vectorLength, double[] array) {
        components = new double[vectorLength];

        System.arraycopy(array, 0, components, 0, Math.min(array.length, vectorLength));
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (double component : components) {
            sb.append(component);
            sb.append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("}");

        return sb.toString();
    }

    public void add(Vector vector) {
        int vectorLength = vector.getLength();

        if (components.length > vectorLength) {
            for (int i = 0; i < vectorLength; i++) {
                components[i] += vector.components[i];
            }
        } else {
            Vector temp = new Vector(vectorLength, components);
            components = new double[vectorLength];

            for (int i = 0; i < components.length; i++) {
                components[i] = temp.components[i] + vector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        int vectorLength = vector.getLength();

        if (components.length > vectorLength) {
            for (int i = 0; i < vectorLength; i++) {
                components[i] -= vector.components[i];
            }
        } else {
            Vector temp = new Vector(vectorLength, components);
            components = new double[vector.getLength()];

            for (int i = 0; i < components.length; i++) {
                components[i] = temp.components[i] - vector.components[i];
            }
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void turn() {
        multiplyByScalar(-1);
    }

    public int getLength() {
        return components.length;
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + components.length;
        hash = prime * hash + Arrays.hashCode(components);
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

        Vector v = (Vector) o;

        if (components.length != v.components.length) {
            return false;
        }

        for (int i = 0; i < components.length; i++) {
            if (components[i] != v.components[i]) {
                return false;
            }
        }

        return true;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector sum = new Vector(vector1);

        sum.add(vector2);

        return sum;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector difference = new Vector(vector1);

        difference.subtract(vector2);

        return difference;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < Math.min(vector1.components.length, vector2.components.length); i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
