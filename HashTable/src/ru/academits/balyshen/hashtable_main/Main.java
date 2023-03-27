package ru.academits.balyshen.hashtable_main;

import ru.academits.balyshen.hashtable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<String> hashTable1 = new HashTable<>();

        System.out.println("Создадим пустую хэш-таблицу 1: " + hashTable1);
        System.out.println();

        int capacity = 15;
        HashTable<String> hashTable2 = new HashTable<>(capacity);

        System.out.println("Создадим пустую хэш-таблицу 2 вместимостью " + capacity + ":" + hashTable2);
        System.out.println();

        System.out.println("1. Проверка метода add:");
        System.out.println("Вставить в хэш-таблицу 1 значения: 2, 3, 5, 6, 7, 8, 9, 10, 11");

        hashTable1.add("2");
        hashTable1.add("3");
        hashTable1.add("5");
        hashTable1.add("6");
        hashTable1.add("7");
        hashTable1.add("8");
        hashTable1.add("9");
        hashTable1.add("10");
        hashTable1.add("11");
        hashTable1.add("12");
        hashTable1.add("13");
        hashTable1.add("15");
        hashTable1.add("16");
        hashTable1.add("17");
        hashTable1.add("18");
        hashTable1.add("19");
        hashTable1.add("20");
        hashTable1.add("22");

        System.out.println("Хэш-таблица 1 после добавления элементов: " + hashTable1);
        System.out.println();

        System.out.println("2. Проверка метода addAll:");

        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("55");
        collection1.add("16");
        collection1.add("45");
        collection1.add("8675");
        collection1.add("75");
        collection1.add("88");

        System.out.println("Вставить в хэш-таблицу 2 значения коллекции " + collection1);

        if (hashTable2.addAll(collection1)) {
            System.out.println("Хэш-таблица 2 после добавления элементов: " + hashTable2);
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

            for (String s : hashTable1) {
                System.out.print(s + " ");
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("4. Проверка метода contains:");

        String searchElement1 = "10";

        System.out.println("Содержит ли хэш-таблица 1 элемент: " + searchElement1 + "?");

        if (hashTable1.contains(searchElement1)) {
            System.out.println("Хэш-таблица 1 содержит элемент: " + searchElement1);
            System.out.println();
        } else {
            System.out.println("Искомый элемент отсуствует");
            System.out.println();
        }

        System.out.println("5. Проверка метода containsAll:");

        ArrayList<String> collection2 = new ArrayList<>();
        collection2.add("7");
        collection2.add("8");
        collection2.add("11");

        System.out.println("Содержит ли хэш-таблица 1 элементы: " + collection2 + "?");

        if (hashTable1.containsAll(collection2)) {
            System.out.println("Хэш-таблица 1 содержит элементы: " + collection2);
            System.out.println();
        } else {
            System.out.println("Искомые элементы отсуствуют");
            System.out.println();
        }

        System.out.println("6. Проверка метода remove:");

        String removedElement1 = "15";

        System.out.println("Удалить из хэш-таблицы 1 элемент: " + removedElement1);

        if (hashTable1.remove(removedElement1)) {
            System.out.println("Из хэш-таблицы 1 удален элемент: " + removedElement1);
            System.out.println("Хэш-таблица 1: " + hashTable1);
            System.out.println();
        } else {
            System.out.println("Удаляемый элемент отсуствует");
            System.out.println();
        }

        System.out.println("7. Проверка метода removeAll:");
        System.out.println("Удалить из хэш-таблицы 1 значения коллекции: " + collection2);

        if (hashTable1.removeAll(collection2)) {
            System.out.println("Из хэш-таблицы 1 удалены значения содержащиеся в коллекции: " + collection2);
            System.out.println("Хэш-таблица 1: " + hashTable1);
            System.out.println();
        } else {
            System.out.println("Указанные значения в хэш-таблицы 1 отсутствует");
            System.out.println("Хэш-таблица 1: " + hashTable1);
            System.out.println();
        }

        System.out.println("8. Проверка метода retainAll:");

        ArrayList<String> collection3 = new ArrayList<>();
        collection3.add("7");
        collection3.add("8675");
        collection3.add("11");

        System.out.println("Удалить из хэш-таблицы 2 все значения не встречающиеся в коллекции " + collection3);

        if (hashTable2.retainAll(collection3)) {
            System.out.println("Хэш-таблица 2 после удаления значений не встречающихся в переданной коллекции: " + hashTable2);
            System.out.println();
        } else {
            System.out.println("В хэш-таблице 2 не содержатся значения из переданной коллекции");
            System.out.println("Хэш-таблица 2: " + hashTable2);
            System.out.println();
        }

        System.out.println("9. Проверка метода clear:");

        hashTable2.clear();

        System.out.println("Хэш-таблица 2 после очистки: " + hashTable2);
        System.out.println();


        System.out.println("10. Проверка метода iterator:");
        System.out.println("Распечаем значения из Списка 1 используя итератор");

        for (String s : hashTable1) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("11. Проверка метода toArray():");

        System.out.println("Массив из хэш-таблицы 1: " + Arrays.toString(hashTable1.toArray()));
        System.out.println();

        System.out.println("12. Проверка метода toArray(T1[] array):");

        String[] array = hashTable1.toArray(new String[6]);

        System.out.println("Массив из хэш-таблицы 1: " + Arrays.toString(array));
        System.out.println();
    }
}
