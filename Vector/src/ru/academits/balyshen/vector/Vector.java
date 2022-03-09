package ru.academits.balyshen.vector;

import java.util.Arrays;

public class Vector {
    private final int n;
    private final double[] vectorComponents;

    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + n);
        }

        this.n = n;
        vectorComponents = new double[n];

        for (int i = 0; i < n; i++) {
            vectorComponents[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this(vector.n, vector.vectorComponents);
    }

    public Vector(double[] array) {
        n = array.length;
        vectorComponents = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            vectorComponents[i] = array[i];
        }
    }

    public Vector(int n, double[] array) {
        this.n = n;
        vectorComponents = new double[n];

        if (array.length < n) {
            for (int i = 0; i < array.length; i++) {
                vectorComponents[i] = array[i];
            }

            for (int i = array.length; i < n; i++) {
                vectorComponents[i] = 0;
            }
        } else {
            for (int i = 0; i < n; i++) {
                vectorComponents[i] = array[i];
            }
        }
    }

    public int getSize() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("{");

        for (int i = 0; i < n; i++) {
            s.append(vectorComponents[i]);

            if (i == n - 1) {
                s.append("}");

                break;
            }

            s.append(", ");
        }

        return s.toString();
    }

    public void addVector(Vector vector) {
        if (n > vector.n) {
            for (int i = 0; i < vector.n; i++) {
                vectorComponents[i] = vectorComponents[i] + vector.vectorComponents[i];
            }
        }

        for (int i = 0; i < n; i++) {
            vectorComponents[i] = vectorComponents[i] + vector.vectorComponents[i];
        }
    }

    public void subtractVector(Vector vector) {
        if (n > vector.n) {
            for (int i = 0; i < vector.n; i++) {
                vectorComponents[i] = vectorComponents[i] - vector.vectorComponents[i];
            }
        }

        for (int i = 0; i < n; i++) {
            vectorComponents[i] = vectorComponents[i] - vector.vectorComponents[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < n; i++) {
            vectorComponents[i] = vectorComponents[i] * scalar;
        }
    }

    public void turnOver() {
        for (int i = 0; i < n; i++) {
            vectorComponents[i] = vectorComponents[i] * -1;
        }
    }

    public double getComponent(int index) {
        return vectorComponents[index];
    }

    public void setComponent(int index, double component) {
        vectorComponents[index] = component;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + n;
        hash = prime * hash + Arrays.hashCode(vectorComponents);
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

        if (n == v.n) {
            for (int i = 0; i < n; i++) {
                if (vectorComponents[i] != v.vectorComponents[i]) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public static Vector getSum(Vector v1, Vector v2) {
        Vector sum = new Vector(Math.max(v1.n, v2.n));

        if (v1.n > v2.n) {
            for (int i = 0; i < v2.n; i++) {
                sum.vectorComponents[i] = v1.vectorComponents[i] + v2.vectorComponents[i];
            }

            for (int i = v2.n; i < v1.n; i++) {
                sum.vectorComponents[i] = v1.vectorComponents[i];
            }

            return sum;
        }

        for (int i = 0; i < v1.n; i++) {
            sum.vectorComponents[i] = v1.vectorComponents[i] + v2.vectorComponents[i];
        }

        for (int i = v1.n; i < v2.n; i++) {
            sum.vectorComponents[i] = v2.vectorComponents[i];
        }

        return sum;
    }

    public static Vector getDifference(Vector v1, Vector v2) {
        Vector difference = new Vector(Math.max(v1.n, v2.n));

        if (v1.n > v2.n) {
            for (int i = 0; i < v2.n; i++) {
                difference.vectorComponents[i] = v1.vectorComponents[i] - v2.vectorComponents[i];
            }

            for (int i = v2.n; i < v1.n; i++) {
                difference.vectorComponents[i] = v1.vectorComponents[i];
            }

            return difference;
        }

        for (int i = 0; i < v1.n; i++) {
            difference.vectorComponents[i] = v1.vectorComponents[i] - v2.vectorComponents[i];
        }

        for (int i = v1.n; i < v2.n; i++) {
            difference.vectorComponents[i] = v2.vectorComponents[i];
        }

        return difference;
    }

    public static double getScalarProduct(Vector v1, Vector v2) {
        double scalarProduct = 0;

        if (v1.n > v2.n) {
            for (int i = 0; i < v2.n; i++) {
                scalarProduct += v1.vectorComponents[i] * v2.vectorComponents[i];
            }

            return scalarProduct;
        }

        for (int i = 0; i < v1.n; i++) {
            scalarProduct += v1.vectorComponents[i] * v2.vectorComponents[i];
        }

        return scalarProduct;
    }
}
