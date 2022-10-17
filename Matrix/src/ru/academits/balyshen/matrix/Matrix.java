package matrix;

import ru.academits.balyshen.vector.Vector;

public class Matrix {
    private final Vector[] components;

    public Matrix(int linesCount, int columnsCount) {
        components = new Vector[linesCount];

        for (int i = 0; i < linesCount; i++) {
            components[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        int linesCount = matrix.getLinesCount();

        components = new Vector[linesCount];

        for (int i = 0; i < linesCount; i++) {
            components[i] = new Vector(matrix.components[i]);
        }
    }

    public Matrix(double[][] array) {
        int maxLength = 0;

        for (double[] doubles : array) {
            if (doubles.length > maxLength) {
                maxLength = doubles.length;
            }
        }

        components = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            components[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] array) {
        int maxSize = 0;

        for (Vector vector : array) {
            if (vector.getLength() > maxSize) {
                maxSize = vector.getSize();
            }
        }

        components = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            components[i] = new Vector(maxSize);
        }
    }

    public int getLinesCount() {
        return components.length;
    }

    public int getColumnsCount() {
        return components[0].getSize();
    }

    public Vector getLinesByIndex(int index) {
        if (index < 0 || index > components.length - 1) {
            throw new IndexOutOfBoundsException("Некорректный индекс: " + index + ". Введите значение от 0 до " + (components.length - 1) + ".");
        }

        return components [index];
    }

    @Override
    public String toString() {
        if (components.length == 0) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (Vector component : components) {
            sb.append(component.toString());
            sb.append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("}");

        return sb.toString();
    }
}
