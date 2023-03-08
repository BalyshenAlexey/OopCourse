package ru.academits.balyshen.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    @SafeVarargs
    public SinglyLinkedList(T... data) {
        for (int i = data.length - 1; i >= 0; i--) {
            addFirst(data[i]);
        }
    }

    public int getCount() {
        return count;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Ошибка! Метод вызван от пустого списка.");
        }

        return head.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        ++count;
    }

    private void checkIndex(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Ошибка! Метод вызван от пустого списка.");
        }

        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Ошибка! Некорректный индекс: " + index + ". Введите значение от 0 до "
                    + (count - 1) + ".");
        }
    }

    private ListItem<T> getItemByIndex(int index) {
        ListItem<T> item = head;
        int i = 0;

        while (i != index) {
            item = item.getNext();

            i++;
        }

        return item;
    }

    public T get(int index) {
        checkIndex(index);

        return getItemByIndex(index).getData();
    }

    public T set(int index, T data) {
        checkIndex(index);

        ListItem<T> item = getItemByIndex(index);
        T oldData = item.getData();
        item.setData(data);

        return oldData;
    }

    public T deleteByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);
        T deletedData = previousItem.getNext().getData();
        previousItem.setNext(previousItem.getNext().getNext());

        --count;

        return deletedData;
    }


    public void addByIndex(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Ошибка! Некорректный индекс: " + index + ". Введите значение от 0 до "
                    + count + ".");
        }

        if (index == 0) {
            addFirst(data);

            return;
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);
        previousItem.setNext(new ListItem<>(data, previousItem.getNext()));

        ++count;
    }

    public boolean deleteByData(T data) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            head = head.getNext();

            --count;

            return true;
        }

        for (ListItem<T> item = head.getNext(), previousItem = head; item != null; previousItem = item, item = item.getNext()) {
            if (Objects.equals(item.getData(), data)) {
                previousItem.setNext(item.getNext());

                --count;

                return true;
            }
        }

        return false;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("Ошибка! Метод вызван от пустого списка.");
        }

        T deletedData = head.getData();
        head = head.getNext();

        --count;

        return deletedData;
    }

    public void reverse() {
        ListItem<T> currentItem = head;
        ListItem<T> previousItem = null;

        while (currentItem != null) {
            ListItem<T> nextItem = currentItem.getNext();
            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    public SinglyLinkedList<T> copy() {
        if (head == null) {
            return new SinglyLinkedList<>();
        }

        ListItem<T> item = head;
        ListItem<T> copyHead = new ListItem<>(item.getData());
        ListItem<T> copyTail = copyHead;

        item = item.getNext();

        while (item != null) {
            copyTail.setNext(new ListItem<>(item.getData()));
            copyTail = copyTail.getNext();

            item = item.getNext();
        }

        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        copy.head = copyHead;
        copy.count = count;

        return copy;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            sb.append(p.getData()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("]");

        return sb.toString();
    }
}
