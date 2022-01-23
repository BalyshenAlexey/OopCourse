package ru.academits.balyshen.range_main;

import ru.academits.balyshen.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное число диапазона:");
        double startNumber = scanner.nextDouble();

        System.out.println("Введите конечное число диапазона:");
        double endNumber = scanner.nextDouble();

        Range range = new Range(startNumber, endNumber);

        System.out.printf("Длина диапазона равна: %.0f.%n", range.getLength());

        System.out.println("Введите число диапазона:");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.printf("Введенное вами число попадает в диапазон от %f до %f.", range.getFrom(), range.getTo());
        } else {
            System.out.println("Введенное вами число не попадает в диапазон. Введите новое начальное число диапазона:");
            range.setFrom(scanner.nextDouble());

            System.out.println("Введите новое конечное число диапазона:");
            range.setTo(scanner.nextDouble());

            if (range.isInside(number)) {
                System.out.printf("Введенное вами число попадает в новый диапазон от %f до %f.", range.getFrom(), range.getTo());
            } else {
                System.out.println("Введенное вами число не попадает в новый диапазон.");
            }
        }
    }
}
