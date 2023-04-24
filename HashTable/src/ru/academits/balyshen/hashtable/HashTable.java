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
        if (object != null) {
            return Math.abs(object.hashCode() % lists.length);
        }

        return 0;
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
        if (collection.size() == 0) {
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

        if (lists[index] == null) {
            return false;
        }

        if (lists[index].remove(object)) {
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
        boolean isDeleted = false;
        int newElementsCount = 0;

        for (ArrayList<E> list : lists) {
            if (list != null) {
                isDeleted = list.retainAll(collection);
                newElementsCount += list.size();
            }
        }

        if (isDeleted) {
            ++modCount;
            elementsCount = newElementsCount;
        }

        return isDeleted;
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
        private int indexInArray = -1;
        private int indexInList = -1;
        private final int expectedModCount = modCount;
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
                } while (lists[indexInArray] == null || lists[indexInArray].size() == 0);
            }

            if (indexInList + 2 < lists[indexInArray].size()) {
                ++indexInList;
                ++passedElementsCount;
                nextElement = lists[indexInArray].get(indexInList);
            } else {
                ++indexInList;
                ++passedElementsCount;
                nextElement = lists[indexInArray].get(indexInList);
                indexInList = -1;
            }

            return nextElement;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[elementsCount];

        int currentPositionInArray = 0;

        for (ArrayList<E> list : lists) {
            if (list != null) {
                System.arraycopy(list.toArray(), 0, array, currentPositionInArray, list.size());
                currentPositionInArray += list.size();
            }
        }

        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < elementsCount) {
            return (T[]) Arrays.copyOf(toArray(), elementsCount, array.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, array, 0, elementsCount);

        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for (ArrayList<E> list : lists) {
            if (list == null) {
                sb.append("null, ");
            } else {
                if (list.size() == 0) {
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
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append(']');

        return sb.toString();
    }
}
