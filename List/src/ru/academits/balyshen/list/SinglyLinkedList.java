package ru.academits.balyshen.list;

import java.util.NoSuchElementException;

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
        return head.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        ++count;
    }

    private void isIndexExist(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("Ошибка! Некорректный индекс: " + index + ". Введите значение от 0 до "
                    + (count - 1) + ".");
        }

        if (head == null) {
            throw new IndexOutOfBoundsException("Ошибка! Некорректный индекс: " + index + ". Текущий список пуст.");
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
        isIndexExist(index);

        return getItemByIndex(index).getData();
    }

    public T set(int index, T data) {
        isIndexExist(index);

        ListItem<T> item = getItemByIndex(index);
        T oldData = item.getData();
        item.setData(data);

        return oldData;
    }

    public T deleteByIndex(int index) {
        isIndexExist(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> item = getItemByIndex(index - 1);
        T deletedData = item.getNext().getData();
        item.setNext(item.getNext().getNext());

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
        } else {
            ListItem<T> item = head;

            for (int i = 0; i < index - 1; i++) {
                item = item.getNext();
            }

            item.setNext(new ListItem<>(data, item.getNext()));

            ++count;
        }
    }

    private boolean isEquals(T data1, T data2) {
        if (data1 == data2) {
            return true;
        }

        if (data1 == null || data2 == null) {
            return false;
        }

        return data1.equals(data2);
    }

    public boolean deleteByData(T data) {
        if (head == null) {
            return false;
        }

        if (isEquals(head.getData(), data)) {
            head = head.getNext();

            --count;

            return true;
        }

        for (ListItem<T> item = head.getNext(), previousItem = head; item != null; previousItem = item, item = item.getNext()) {
            if (isEquals(item.getData(), data)) {
                previousItem.setNext(item.getNext());

                --count;

                return true;
            }
        }

        return false;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("Ошибка! Передан пустой список.");
        }

        T deletedData = head.getData();
        head = head.getNext();

        --count;

        return deletedData;
    }

    public void reverse() {
        ListItem<T> currentItem = head;
        ListItem<T> previousItem = null;
        ListItem<T> nextItem;

        while (currentItem != null) {
            nextItem = currentItem.getNext();
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
            copyTail.setNext(null);

            item = item.getNext();
        }

        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        copy.head = copyHead;

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
