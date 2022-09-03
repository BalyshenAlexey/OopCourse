package ru.academits.balyshen.arraylisthome;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("ArrayListHome\\ArrayListHome_input.txt");
            BufferedReader br = new BufferedReader(reader);

            ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            if (lines.isEmpty()) {
                System.out.println("Передан пустой файл");
                System.out.println();
            } else {
                System.out.println("Список строк из файла: " + lines);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка! Файл отсутствует");
        }

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Первый список целых чисел: " + list1);

        for (int i = 0; i < list1.size(); i++) {
            if (isEven(list1.get(i))) {
                list1.remove(list1.get(i));
            }
        }

        System.out.println("Первый список целых чисел после удаления четных чисел: " + list1);
        System.out.println();

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 1, 4));
        System.out.println("Второй список целых чисел: " + list2);

        ArrayList<Integer> list2WithoutRepeats = new ArrayList<>(list2.size());

        for (int i = 0; i < list2.size(); i++) {
            if (list2.indexOf(list2.get(i)) == i) {
                list2WithoutRepeats.add(list2.get(i));
            }
        }

        System.out.println("Второй список целых чисел без повторов: " + list2WithoutRepeats);
    }
}
