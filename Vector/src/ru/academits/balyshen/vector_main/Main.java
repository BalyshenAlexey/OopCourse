package ru.academits.balyshen.vector_main;

import ru.academits.balyshen.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(6);

        double [] array1 = {1, 3, 2, 4, 7};
        Vector vector2 = new Vector(array1);

        Vector vector3 = new Vector(vector2);

        double [] array2 = {1, 3, 2, 4, 7};
        Vector vector4 = new Vector(10, array2);

        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
        System.out.println(vector4);
    }
}
