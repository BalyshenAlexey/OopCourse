package ru.academits.balyshen.range_main;

import ru.academits.balyshen.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число первого диапазона:");
        double startNumber1 = scanner.nextDouble();

        System.out.println("Введите конечное число первого диапазона:");
        double endNumber1 = scanner.nextDouble();

        Range range1 = new Range(startNumber1, endNumber1);

        System.out.println("Введите начальное число второго диапазона:");
        double startNumber2 = scanner.nextDouble();

        System.out.println("Введите конечное число второго диапазона:");
        double endNumber2 = scanner.nextDouble();

        Range range2 = new Range(startNumber2, endNumber2);

        Range range3 = range1.getIntersection(range2);

        System.out.printf("Пересечение: новый диапазон от %f до %f.", range3.getFrom(), range3.getTo());
    }
}
