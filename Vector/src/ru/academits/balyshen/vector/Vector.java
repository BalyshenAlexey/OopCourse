package ru.academits.balyshen.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] vectorComponents;

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
        n = vector.n;
        vectorComponents = vector.vectorComponents;
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


    @Override
    public String toString() {
        return Arrays.toString(vectorComponents);
    }
}
