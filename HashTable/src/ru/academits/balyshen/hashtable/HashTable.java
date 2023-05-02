package ru.academits.balyshen.hashtable;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private final ArrayList<E>[] lists;
    private int modCount;
    private int elementsCount;

    @SuppressWarnings("unchecked")
    public HashTable() {
        lists = new ArrayList[DEFAULT_CAPACITY];
    }

    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + capacity + ". Вместимость должна быть больше 0.");
        }

        //noinspection unchecked
        lists = new ArrayList[capacity];
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    private int getIndex(Object object) {
        return object != null ? Math.abs(object.hashCode() % lists.length) : 0;
    }

    @Override
    public boolean add(E element) {
        int index = getIndex(element);

        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }

        lists[index].add(element);

        ++modCount;
        ++elementsCount;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (E element : collection) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean contains(Object object) {
        int index = getIndex(object);

        return lists[index] != null && lists[index].contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = getIndex(object);

        if (lists[index] != null && lists[index].remove(object)) {
            ++modCount;
            --elementsCount;

            return true;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isDeleted = false;

        for (Object element : collection) {
            boolean isElementDeleted;

            do {
                isElementDeleted = remove(element);

                isDeleted |= isElementDeleted;
            } while (isElementDeleted);
        }

        return isDeleted;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int newElementsCount = 0;

        for (ArrayList<E> list : lists) {
            if (list != null) {
                list.retainAll(collection);
                newElementsCount += list.size();
            }
        }

        if (elementsCount == newElementsCount) {
            return false;
        }

        ++modCount;
        elementsCount = newElementsCount;

        return true;
    }

    @Override
    public void clear() {
        if (elementsCount != 0) {
            Arrays.fill(lists, null);
            ++modCount;
            elementsCount = 0;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new HashTableIterator();
    }

    private class HashTableIterator implements Iterator<E> {
        private final int expectedModCount = modCount;
        private int indexInArray = -1;
        private int indexInList = -1;
        private int passedElementsCount = 0;

        public boolean hasNext() {
            return passedElementsCount < elementsCount;
        }

        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("Текущий список изменен.");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("В списке больше нет элементов.");
            }

            E nextElement;

            if (indexInList == -1) {
                do {
                    ++indexInArray;
                } while (lists[indexInArray] == null || lists[indexInArray].isEmpty());
            }

            ++indexInList;
            ++passedElementsCount;
            nextElement = lists[indexInArray].get(indexInList);

            if (indexInList + 1 >= lists[indexInArray].size()) {
                indexInList = -1;
            }

            return nextElement;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[elementsCount];
        int index = 0;

        for (E element : this) {
            array[index++] = element;
        }

        return array;
    }


    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < elementsCount) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(toArray(), elementsCount, array.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, array, 0, elementsCount);

        if (array.length > elementsCount) {
            array[elementsCount] = null;
        }

        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for (ArrayList<E> list : lists) {
            if (list == null) {
                sb.append("null, ");
                continue;
            }

            if (list.isEmpty()) {
                sb.append("[], ");
            } else {
                sb.append('[');

                for (E element : list) {
                    sb.append(element).append(", ");
                }

                sb.delete(sb.length() - 2, sb.length());

                sb.append("], ");
            }
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append(']');

        return sb.toString();
    }
}
