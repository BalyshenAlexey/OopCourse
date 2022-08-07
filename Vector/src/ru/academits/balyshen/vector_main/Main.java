package ru.academits.balyshen.vector_main;

import ru.academits.balyshen.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(6);

        double[] array1 = {1, 3, 2, 4, 7};
        Vector vector2 = new Vector(array1);

        double[] array2 = {1, 5, 2, 4, 7, 4, 8};
        Vector vector3 = new Vector(10, array2);

        System.out.println("Вектор 1: " + vector1);
        System.out.println("Вектор 2: " + vector2 + " с размерностью: " + vector2.getSize());
        System.out.println("Вектор 3: " + vector3 + " с размерностью: " + vector3.getSize());
        System.out.println();

        System.out.println("Длина Вектора 2: " + vector2.getLength());

        Vector vector2Copy1 = new Vector(vector2);
        vector2Copy1.add(vector3);
        System.out.println("Вектор 2 + Вектор 3: " + vector2Copy1);

        Vector vector2Copy2 = new Vector(vector2);
        vector2Copy2.subtract(vector3);
        System.out.println("Вектор 2 - Вектор 3: " + vector2Copy2);

        Vector vector3Copy1 = new Vector(vector3);
        vector3Copy1.multiplyByScalar(4);
        System.out.println("Вектор 3 * 4: " + vector3Copy1);

        Vector vector3Copy2 = new Vector(vector3);
        vector3Copy2.turn();
        System.out.println("Вектор противоположный вектору 3: " + vector3Copy2);

        System.out.println("Третья компонента вектора 3: " + vector2.getComponent(2));

        System.out.println("Заменим третью компоненту вектора 3 на 7");
        vector2.setComponent(2, 7);

        System.out.println("Вектор 3 после изменения: " + vector2);

        Vector vector4 = Vector.getSum(vector2, vector3);
        System.out.println("Вектор 4 равный сумме векторов 2 и 3: " + vector4);

        Vector vector5 = Vector.getDifference(vector2, vector3);
        System.out.println("Вектор 5 равный разности векторов 2 и 3: " + vector5);

        System.out.println("Скалярное произведение векторов 2 и 3: " + Vector.getScalarProduct(vector2, vector3));
    }
}
