package ru.academits.balyshen.range_main;

import ru.academits.balyshen.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число диапазона A:");
        double startNumberA = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона A:");
        double endNumberA = scanner.nextDouble();

        Range rangeA = new Range(startNumberA, endNumberA);

        System.out.println("Введите начальное число диапазона B:");
        double startNumberB = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона B:");
        double endNumberB = scanner.nextDouble();

        Range rangeB = new Range(startNumberB, endNumberB);

        Range intersectionRange = rangeA.getIntersection(rangeB);

        if (intersectionRange == null) {
            System.out.println("Диапазоны A и B не пересекаются.");
        } else {
            System.out.printf("Пересечение дианпазонов A и B: диапазон от %f до %f.%n", intersectionRange.getFrom(), intersectionRange.getTo());
        }

        Range[] unionRange = rangeA.getUnion(rangeB);

        if (unionRange.length == 2) {
            System.out.printf("Объединение диапазонов A и B: диапазоны от %f до %f и от %f до %f.%n",
                    unionRange[0].getFrom(), unionRange[0].getTo(), unionRange[1].getFrom(), unionRange[1].getTo());
        } else {
            System.out.printf("Объединение диапазонов A и B: диапазон от %f до %f.%n", unionRange[0].getFrom(), unionRange[0].getTo());
        }

        Range[] complementRange = rangeA.getComplement(rangeB);

        if (complementRange == null) {
            System.out.println("Диапазоны A и B равны.");
        } else if (complementRange.length == 2) {
            System.out.printf("Разность диапазонов A и B: диапазоны от %f до %f и от %f до %f.%n",
                    complementRange[0].getFrom(), complementRange[0].getTo(), complementRange[1].getFrom(), complementRange[1].getTo());
        } else {
            System.out.printf("Разность диапазонов A и B: диапазон от %f до %f.", complementRange[0].getFrom(), complementRange[0].getTo());
        }
    }
}
