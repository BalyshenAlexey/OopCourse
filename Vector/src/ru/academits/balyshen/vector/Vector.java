package ru.academits.balyshen.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + vectorSize + ". Введите значение больше 0.");
        }

        components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Некорректная размерность. Должен быть не пустой массив.");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int vectorSize, double[] array) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + vectorSize + ". Введите значение больше 0.");
        }

        components = Arrays.copyOf(array, vectorSize);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (double component : components) {
            sb.append(component).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("}");

        return sb.toString();
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);

            for (int i = 0; i < components.length; i++) {
                components[i] += vector.components[i];
            }
        } else {
            for (int i = 0; i < vector.components.length; i++) {
                components[i] += vector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);

            for (int i = 0; i < components.length; i++) {
                components[i] -= vector.components[i];
            }
        } else {
            for (int i = 0; i < vector.components.length; i++) {
                components[i] -= vector.components[i];
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

    public double getLength() {
        double componentsSquaresSum = 0;

        for (double component : components) {
            componentsSquaresSum += component * component;
        }

        return Math.sqrt(componentsSquaresSum);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
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

        return Arrays.equals(components, v.components);
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
        int minSize = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
