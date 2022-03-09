package ru.academits.balyshen.vector_main;

import ru.academits.balyshen.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector0 = new Vector(6);

        double[] array1 = {1, 3, 2, 4, 7};
        Vector vector1 = new Vector(array1);

        double[] array2 = {1, 5, 2, 4, 7, 4, 8};
        Vector vector2 = new Vector(8, array2);

        System.out.println("Нулевой вектор: " + vector0);
        System.out.println("Вектор 1: " + vector1 + " с размерностью: " + vector1.getSize());
        System.out.println("Вектор 2: " + vector2 + " с размерностью: " + vector2.getSize());
        System.out.println();

        Vector vector1Copy1 = new Vector(vector1);
        vector1Copy1.addVector(vector2);
        System.out.println("Вектор 1 + Вектор 2: " + vector1Copy1);

        Vector vector1Copy2 = new Vector(vector1);
        vector1Copy2.subtractVector(vector2);
        System.out.println("Вектор 1 - Вектор 2: " + vector1Copy2);

        Vector vector2Copy1 = new Vector(vector2);
        vector2Copy1.multiplyByScalar(4);
        System.out.println("Вектор 2 * 4: " + vector2Copy1);

        Vector vector2Copy2 = new Vector(vector2);
        vector2Copy2.turnOver();
        System.out.println("Вектор противоположный вектору 2: " + vector2Copy2);

        System.out.println("3 компонента вектора 2: " + vector2.getComponent(2));

        System.out.println("Заменим 3 компоненту вектора 2 на 7");
        vector2.setComponent(2, 7);

        System.out.println("Вектор 2 после изменения: " + vector2);

        Vector vector3 = Vector.getSum(vector1, vector2);
        System.out.println("Вектор 3 равный сумме векторов 1 и 2: " + vector3);

        Vector vector4 = Vector.getDifference(vector1, vector2);
        System.out.println("Вектор 4 равный разности векторов 1 и 2: " + vector4);

        System.out.println("Скалярное произведение векторов 1 и 2: " + Vector.getScalarProduct(vector1, vector2));
    }
}
