package ru.academits.balyshen.range_main;

import ru.academits.balyshen.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число диапазона 1:");
        double from1 = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона 1:");
        double to1 = scanner.nextDouble();

        Range range1 = new Range(from1, to1);

        System.out.println("Введите начальное число диапазона 2:");
        double from2 = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона 2:");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from2, to2);

        System.out.println("Введите новое начальное число диапазона 1:");
        range1.setFrom(scanner.nextDouble());

        System.out.println("Введите новое конечное число диапазона 1:");
        range1.setTo(scanner.nextDouble());

        System.out.println("Новый диапазон 1 от " + range1.getFrom() + " до " + range1.getTo() + ". Длинна: " + range1.getLength());

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Диапазоны A и B не пересекаются.");
        } else {
            System.out.println("Пересечение диапазонов A и B:" + intersection);
        }

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединение диапазонов A и B:" + Arrays.toString(union));


        Range[] difference = range1.getDifference(range2);
        System.out.println("Разность диапазонов A и B:" + Arrays.toString(difference));
    }
}
