package ru.academits.balyshen.hash_table_main;

import ru.academits.balyshen.hash_table.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hashTable1 = new HashTable<>();

        System.out.println("Создадим пустую хэш-таблицу 1: " + hashTable1);
        System.out.println();

        int capacity = 15;
        HashTable<Integer> hashTable2 = new HashTable<>(capacity);

        System.out.println("Создадим пустую хэш-таблицу 2 вместимостью " + capacity + ": " + hashTable2);
        System.out.println();

        System.out.println("1. Проверка метода add:");
        System.out.println("Вставить в хэш-таблицу 1 значения: null, 2, 3, 6, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 22");

        hashTable1.add(null);
        hashTable1.add(2);
        hashTable1.add(3);
        hashTable1.add(6);
        hashTable1.add(8);
        hashTable1.add(9);
        hashTable1.add(10);
        hashTable1.add(11);
        hashTable1.add(12);
        hashTable1.add(13);
        hashTable1.add(15);
        hashTable1.add(16);
        hashTable1.add(17);
        hashTable1.add(18);
        hashTable1.add(19);
        hashTable1.add(20);
        hashTable1.add(22);

        System.out.println("Хэш-таблица 1 после добавления элементов: " + hashTable1);
        System.out.println("Размер хэш-таблицы: " + hashTable1.size());
        System.out.println();

        System.out.println("2. Проверка метода addAll:");

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(55);
        list1.add(16);
        list1.add(45);
        list1.add(8675);
        list1.add(75);
        list1.add(88);

        System.out.println("Вставить в хэш-таблицу 2 значения коллекции " + list1);

        if (hashTable2.addAll(list1)) {
            System.out.println("Хэш-таблица 2 после добавления элементов: " + hashTable2);
            System.out.println("Размер хэш-таблицы: " + hashTable2.size());
            System.out.println();
        } else {
            System.out.println("В хэш-таблицу не добавлено новых элементов");
            System.out.println();
        }

        System.out.println("3. Проверка метода isEmpty:");

        if (hashTable1.isEmpty()) {
            System.out.println("Хэш-таблица не содержит элементов.");
            System.out.println();
        } else {
            System.out.print("В хэш-таблице содержатся элементы: ");

            for (Integer number : hashTable1) {
                System.out.print(number + " ");
            }

            System.out.println();
            System.out.println("Размер хэш-таблицы: " + hashTable1.size());
            System.out.println();
        }

        System.out.println("4. Проверка метода contains:");

        Integer searchElement1 = 2;

        System.out.println("Содержит ли хэш-таблица 1 элемент: " + searchElement1 + "?");

        if (hashTable1.contains(searchElement1)) {
            System.out.println("Хэш-таблица 1 содержит элемент: " + searchElement1);
            System.out.println();
        } else {
            System.out.println("Искомый элемент отсутствует");
            System.out.println();
        }

        System.out.println("5. Проверка метода containsAll:");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(8);
        list2.add(11);

        System.out.println("Содержит ли хэш-таблица 1 элементы: " + list2 + "?");

        if (hashTable1.containsAll(list2)) {
            System.out.println("Хэш-таблица 1 содержит элементы: " + list2);
            System.out.println();
        } else {
            System.out.println("Искомые элементы отсутствуют");
            System.out.println();
        }

        System.out.println("6. Проверка метода remove:");

        Integer removedElement1 = 15;

        System.out.println("Удалить из хэш-таблицы 1 элемент: " + removedElement1);

        if (hashTable1.remove(removedElement1)) {
            System.out.println("Из хэш-таблицы 1 удален элемент: " + removedElement1);
            System.out.println("Хэш-таблица 1: " + hashTable1);
            System.out.println("Размер хэш-таблицы: " + hashTable1.size());
            System.out.println();
        } else {
            System.out.println("Удаляемый элемент отсутствует");
            System.out.println();
        }

        System.out.println("7. Проверка метода removeAll:");
        System.out.println("Удалить из хэш-таблицы 1 значения коллекции: " + list2);

        if (hashTable1.removeAll(list2)) {
            System.out.println("Из хэш-таблицы 1 удалены значения содержащиеся в коллекции: " + list2);
            System.out.println("Хэш-таблица 1: " + hashTable1);
            System.out.println("Размер хэш-таблицы: " + hashTable1.size());
            System.out.println();
        } else {
            System.out.println("Указанные значения в хэш-таблицы 1 отсутствуют");
            System.out.println("Хэш-таблица 1: " + hashTable1);
            System.out.println("Размер хэш-таблицы: " + hashTable1.size());
            System.out.println();
        }

        System.out.println("8. Проверка метода retainAll:");

        ArrayList<Integer> collection3 = new ArrayList<>();
        collection3.add(75);
        collection3.add(8675);
        collection3.add(16);

        System.out.println("Удалить из хэш-таблицы 2 все значения не встречающиеся в коллекции " + collection3);

        if (hashTable2.retainAll(collection3)) {
            System.out.println("Хэш-таблица 2 после удаления значений не встречающихся в переданной коллекции: " + hashTable2);
            System.out.println("Размер хэш-таблицы: " + hashTable2.size());
            System.out.println();
        } else {
            System.out.println("В хэш-таблице 2 не содержатся значения из переданной коллекции");
            System.out.println("Хэш-таблица 2: " + hashTable2);
            System.out.println("Размер хэш-таблицы: " + hashTable2.size());
            System.out.println();
        }

        System.out.println("9. Проверка метода clear:");

        hashTable2.clear();

        System.out.println("Хэш-таблица 2 после очистки: " + hashTable2);
        System.out.println();

        System.out.println("10. Проверка метода iterator:");
        System.out.print("Распечатаем значения из Списка 1 используя итератор: ");

        for (Integer s : hashTable1) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("11. Проверка метода toArray():");

        System.out.println("Массив из хэш-таблицы 1: " + Arrays.toString(hashTable1.toArray()));
        System.out.println();

        System.out.println("12. Проверка метода toArray(T1[] array):");

        Integer[] array = hashTable1.toArray(new Integer[5]);

        System.out.println("Массив из хэш-таблицы 1: " + Arrays.toString(array));
        System.out.println();
    }
}
