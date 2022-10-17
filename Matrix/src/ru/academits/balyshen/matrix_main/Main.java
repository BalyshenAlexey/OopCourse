package matrix_main;

import matrix.Matrix;
import ru.academits.balyshen.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Проверка конструктора типа Matrix(n, m):");

        int linesCount = 5;
        int columnsCount = 3;

        Matrix matrix1 = new Matrix(linesCount, columnsCount);

        System.out.println("Создадим матрицу нулей размером " + linesCount + " на " + columnsCount);
        System.out.println("Матрица 1: " + matrix1);

        Matrix matrix1Copy1 = new Matrix(matrix1);

        System.out.println(matrix1Copy1);

        double[][] array1 = {{1, 3, 2, 4, 7}, {1, 5, 2, 4, 7, 4, 8}};
        Matrix matrix2 = new Matrix(array1);

        System.out.println(matrix2);

        double[] array2 = {1, 3, 2, 4, 7};
        Vector vector1 = new Vector(array2);

        double[] array3 = {1, 5, 2, 4, 7, 4, 8};
        Vector vector2 = new Vector(array3);

        Vector[] array4 = {vector1, vector2};

        Matrix matrix3 = new Matrix(array4);

        System.out.println(matrix3);
    }
}
