package ru.academits.balyshen.array_list;

import java.util.*;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;
    private int length;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        items = (T[]) new Object[capacity];
    }

    @Override
    public boolean add(T element) {
        if (length >= items.length) {
            increaseCapacity();
        }

        items[length] = element;

        ++length;
        ++modCount;

        return true;
    }

    @Override
    public void add(int index, T element) {
        isIndexExist(index);

        if (length >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + 1, length - index);

        items[index] = element;

        ++length;
        ++modCount;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T element : collection) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        isIndexExist(index);

        if (length + collection.size() >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + collection.size(), length - index);

        int i = index;

        for (T element : collection) {
            set(i, element);
            i++;
        }

        length += collection.size();

        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        items = (T[]) new Object[items.length];
        length = 0;
        modCount = 0;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity <= items.length) {
            return;
        }

        items = Arrays.copyOf(items, requiredCapacity);

        ++modCount;
    }

    @Override
    public T get(int index) {
        isIndexExist(index);

        return items[index];
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);

        ++modCount;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i <= length - 1; i++) {
            if (isEquals(items[i], element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    private boolean isEquals(T element1, T element2) {
        if (element1 == element2) {
            return true;
        }

        if (element1 == null || element2 == null) {
            return false;
        }

        return element1.equals(element2);
    }

    private void isIndexExist(int index) {
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Некорректный индекс: " + index + ". Введите значение от 0 до " + (length - 1) + ".");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;

        int expectedModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (currentIndex == length) {
                throw new NoSuchElementException();
            }

            ++currentIndex;
            return items[currentIndex];
        }
    }

    @Override
    public int lastIndexOf(T element) {
        int lastIndex = -1;

        for (int i = 0; i <= length - 1; i++) {
            if (isEquals(items[i], element)) {
                lastIndex = i;
            }
        }

        return lastIndex;
    }

    @Override
    public T remove(int index) {
        isIndexExist(index);

        T oldElement = get(index);

        if (index == length) {
            --length;
            ++modCount;

            return oldElement;
        }

        System.arraycopy(items, index + 1, items, index, length - index - 1);

        --length;
        ++modCount;

        return oldElement;
    }

    @Override
    public boolean remove(T element) {
        int elementIndex = indexOf(element);

        if (elementIndex == -1) {
            return false;
        }

        remove(elementIndex);

        return true;
    }

    @Override
    public boolean removeAll(Collection<? extends T> collection) {
        boolean isDeleted = false;

        for (T element : collection) {
            isDeleted |= remove(element);
        }

        return isDeleted;
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        isIndexExist(fromIndex);
        isIndexExist(toIndex);

        System.arraycopy(items, toIndex, items, fromIndex, length - toIndex);

        length -= toIndex - fromIndex;
        ++modCount;
    }

    @Override
    public boolean retainAll(Collection<? extends T> collection) {
        boolean isDeleted = false;

        for (int i = 0; i <= length - 1; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;

                isDeleted = true;
            }
        }

        return isDeleted;
    }

    @Override
    public T set(int index, T element) {
        isIndexExist(index);

        T oldElement = get(index);
        items[index] = element;

        ++modCount;

        return oldElement;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] array) {
        if (array.length < length) {
            return (T[]) Arrays.copyOf(items, length, array.getClass());
        }

        System.arraycopy(items, 0, array, 0, length);

        return array;
    }

    @Override
    public void trimToSize() {
        items = Arrays.copyOf(items, length);
    }

    public String toString() {
        if (length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < length; i++) {
            sb.append(items[i]).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("]");

        return sb.toString();
    }
}
