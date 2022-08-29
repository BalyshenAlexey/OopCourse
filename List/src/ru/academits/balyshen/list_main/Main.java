package ru.academits.balyshen.list_main;

import ru.academits.balyshen.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);

        System.out.println("Список: " + list);
        System.out.println();

        System.out.println("Проверка метода получения размера списка:");
        System.out.println("Размер списка: " + list.getCount());
        System.out.println();

        System.out.println("Проверка метода получения значения первого элемента:");
        System.out.println("Значение первого элемента: " + list.getHead());
        System.out.println();

        System.out.println("Проверка метода получения значения по указанному индексу:");

        int index1 = 10;

        System.out.println("Значение по индексу " + index1 + ": " + list.getDataByIndex(index1));
        System.out.println();

        System.out.println("Проверка метода изменения значения по указанному индексу:");

        int index2 = 2;
        Integer data1 = 25;

        System.out.println("Изменить значение по индексу " + index2 + " на " + data1 + ". Старое значение : " + list.changeDataByIndex(index2, data1));
        System.out.println("Список: " + list);
        System.out.println("Размер списка: " + list.getCount());
        System.out.println();

        System.out.println("Проверка метода удаления элемента по индексу:");

        int index3 = 4;

        System.out.println("Удалить элемент по индексу " + index3 + ". Удален элемент со значением: " + list.deleteItemByIndex(index3));
        System.out.println("Список: " + list);
        System.out.println("Размер списка: " + list.getCount());
        System.out.println();

        System.out.println("Проверка метода вставки элемента по индексу:");

        int index4 = 1;
        Integer data2 = 5;

        System.out.println("Вставить значение " + data2 + " по индексу " + index4);

        list.addItemByIndex(index4, data2);

        System.out.println("Список: " + list);
        System.out.println("Размер списка: " + list.getCount());
        System.out.println();

        System.out.println("Проверка метода удаления узла по значению:");

        Integer data3 = 25;

        System.out.println("Удалить элемент со значением " + data3);

        if (list.deleteItemByData(data3)){
            System.out.println("Элемент удален");
        } else {
            System.out.println("Элемент со значением " + data3 + " в списке отсутствует");
        }

        System.out.println("Список: " + list);
        System.out.println("Размер списка: " + list.getCount());
        System.out.println();

        System.out.println("Проверка метода удаления первого элемента:");
        System.out.println("Удален первый элемент. Значение: " + list.deleteFirst());
        System.out.println("Список: " + list);
        System.out.println("Размер списка: " + list.getCount());
        System.out.println();

        System.out.println("Проверка метода разворота списка:");
        list.reverse(list);
        System.out.println("Список: " + list);
        System.out.println();

        System.out.println("Проверка метода копирования списка:");
        SinglyLinkedList<Integer> listCopy = list.copy();
        System.out.println("Копия списка: " + listCopy);
    }
}
