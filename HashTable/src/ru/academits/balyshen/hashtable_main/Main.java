package ru.academits.balyshen.hashtable_main;

import ru.academits.balyshen.hashtable.HashTable;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashTable<String> hashTable1 = new HashTable<>();
        System.out.println(hashTable1.isEmpty());

        hashTable1.add("2");
        hashTable1.add("3");
        hashTable1.add("5");
        hashTable1.add("6");
        hashTable1.add("7");
        hashTable1.add("8");
        hashTable1.add("9");
        hashTable1.add("10");
        hashTable1.add("11");

        System.out.println(hashTable1);
        System.out.println(hashTable1.isEmpty());

        System.out.println("11. Проверка метода iterator:");
        System.out.println("Распечаем значения из Списка 1 используя итератор");

        Iterator<String> iterator = hashTable1.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }



        System.out.println();
        System.out.println();

    }
}
