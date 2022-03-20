package ru.academits.balyshen.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome_input.txt"))) {
            ArrayList<String> lines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            System.out.println("Список строк из файла: " + lines);
        }

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (Integer number : list1) {
            if (isEven(number)) {
                list1.remove(number);
            }
        }

        System.out.println("Список четных чисел из списка 1: " + list1);
    }
}
