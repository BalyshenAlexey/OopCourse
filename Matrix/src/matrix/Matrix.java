package matrix;

import ru.academits.balyshen.vector.Vector;

public class Matrix {
    private Vector[] components;

    public Matrix(int linesCount, int columnsCount) {
        components = new Vector[linesCount];

        for (int i = 0; i < linesCount; i++) {
            components[i] = new Vector(columnsCount);
        }
    }

    public Matrix(Matrix matrix) {
        this.components = matrix.components;
    }

    public Matrix(double[][] array) {
        int maxLength = 1;

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
        int maxSize = 1;

        for (Vector vector : array) {
            if (vector.getLength() > maxSize) {
                maxSize = vector.getSize();
            }
        }

        components = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            components[i] = new Vector(array[i]);
        }
    }

    @Override
    public String toString() {
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
