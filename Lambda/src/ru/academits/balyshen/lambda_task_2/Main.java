package ru.academits.balyshen.lambda_task_2;

import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DoubleStream squareRoots = DoubleStream
                .iterate(0, x -> x + 1)
                .map(Math::sqrt);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов, которые необходимо вычислить:");
        int elementsCount = scanner.nextInt();

        System.out.println("Квадратные корни первых " + elementsCount + " элементов:");
        squareRoots
                .limit(elementsCount)
                .forEach(System.out::println);

        System.out.println();

        Stream<Integer> fibonacciNumbers = Stream
                .iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .map(x -> x[0]);

        System.out.println("Введите количество элементов в последовательности чисел Фибоначчи, которые необходимо вывести:");
        int fibonacciNumbersCount = scanner.nextInt();

        System.out.println(fibonacciNumbersCount + " первых элементов в последовательности чисел Фибоначчи:");
        fibonacciNumbers
                .limit(fibonacciNumbersCount)
                .forEach(System.out::println);
    }
}
