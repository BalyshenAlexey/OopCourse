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
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome\\ArrayListHome_input.txt"))) {
            ArrayList<String> lines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            System.out.println("Список строк из файла: " + lines);
        }

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Список 1: " + list1);

        list1.removeIf(ArrayListHome::isEven);
        System.out.println("Список 1 после удаления четных чисел: " + list1);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 1));
        System.out.println("Список 2: " + list2);

        ArrayList<Integer> list3 = new ArrayList<>();

        boolean isNotRepeat;

        for (int i = 0; i < list2.size(); i++) {
            isNotRepeat = true;

            for (int j = i - 1; j >= 0; j--) {
                if (list2.get(i).equals(list2.get(j))) {
                    isNotRepeat = false;
                    break;
                }
            }

            if (isNotRepeat) {
                list3.add(list2.get(i));
            }
        }

        System.out.println("Список 3: " + list3);
    }
}
