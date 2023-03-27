package ru.academits.balyshen.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] items;
    private int size;
    private int modCount;

    public ArrayList() {
        items = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + initialCapacity + ". Введите значение больше 0.");
        }

        items = (E[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(E item) {
        add(size, item);

        return true;
    }

    @Override
    public void add(int index, E item) {
        if (index != size) {
            checkIndex(index);
        }

        if (size >= items.length) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + 1, size - index);

        items[index] = item;

        ++size;
        ++modCount;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (index != size) {
            checkIndex(index);
        }

        ++modCount;

        if (collection.size() == 0) {
            return false;
        }

        ensureCapacity(size + collection.size());

        System.arraycopy(items, index, items, index + collection.size(), size - index);

        int i = index;

        for (E item : collection) {
            items[i] = item;
            i++;
        }

        size += collection.size();

        return true;
    }

    @Override
    public void clear() {
        if (size == 0) {
            return;
        }

        Arrays.fill(items, null);

        size = 0;
        ++modCount;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    public void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > items.length) {
            items = Arrays.copyOf(items, requiredCapacity);
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return items[index];
    }

    @Override
    public E set(int index, E item) {
        checkIndex(index);

        E oldItem = items[index];
        items[index] = item;

        return oldItem;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, Math.max(items.length * 2, DEFAULT_CAPACITY));
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size; i >= 0; i--) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс: " + index + ". Метод вызван от пустого списка.");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Некорректный индекс: " + index + ". Индекс должен быть от 0 до " + (size - 1) + ".");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private final int expectedModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("Ошибка! Текущий список изменен.");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("Ошибка! В списке больше нет элементов.");
            }

            ++currentIndex;
            return items[currentIndex];
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E deletedItem = items[index];

        if (index == size - 1) {
            items[size - 1] = null;

            --size;
            ++modCount;

            return deletedItem;
        }

        System.arraycopy(items, index + 1, items, index, size - index - 1);

        items[size - 1] = null;

        --size;
        ++modCount;

        return deletedItem;
    }

    @Override
    public boolean remove(Object object) {
        int itemIndex = indexOf(object);

        if (itemIndex == -1) {
            return false;
        }

        remove(itemIndex);

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (size == 0) {
            return false;
        }

        boolean isDeleted = false;

        for (Object item : collection) {
            boolean isItemDeleted;

            do {
                isItemDeleted = remove(item);

                isDeleted |= isItemDeleted;
            } while (isItemDeleted);
        }

        return isDeleted;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean isDeleted = false;

        for (int i = 0; i < size; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;

                isDeleted = true;
            }
        }

        return isDeleted;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            return (T[]) Arrays.copyOf(items, size, array.getClass());
        }

        System.arraycopy(items, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    public void trimToSize() {
        if (items.length != size) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; i < size; i++) {
            sb.append(items[i]).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');

        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
