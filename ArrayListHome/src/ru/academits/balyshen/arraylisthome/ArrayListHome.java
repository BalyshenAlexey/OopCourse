package ru.academits.balyshen.arraylisthome;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ArrayListHome\\ArrayListHome_input.txt"))) {
            ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            if (lines.isEmpty()) {
                System.out.println("Передан пустой файл");
                System.out.println();
            } else {
                System.out.println("Список строк из файла: " + lines);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка ввода! Отсутствует необходимый файл или указан неверный путь");
        } catch (IOException e) {
            System.out.println("Ошибка ввода!");
        }

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Первый список целых чисел: " + list1);

        for (int i = 0; i <= list1.size() - 1; i++) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i);
                i--;
            }
        }

        System.out.println("Первый список целых чисел после удаления четных чисел: " + list1);
        System.out.println();

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 1, 4));
        System.out.println("Второй список целых чисел: " + list2);

        ArrayList<Integer> list2WithoutRepeats = new ArrayList<>(list2.size());

        for (Integer number : list2) {
            if (!list2WithoutRepeats.contains(number)) {
                list2WithoutRepeats.add(number);
            }
        }

        System.out.println("Второй список целых чисел без повторов: " + list2WithoutRepeats);
    }
}
