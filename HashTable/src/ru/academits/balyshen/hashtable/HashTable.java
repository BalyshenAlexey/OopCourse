package ru.academits.balyshen.hashtable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private ArrayList<T>[] hashTable;
    private int modCount;

    @SuppressWarnings("unchecked")
    public HashTable() {
        hashTable = new ArrayList[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        hashTable = new ArrayList[capacity];
    }

    @Override
    public int size() {
        return hashTable.length;
    }

    @Override
    public boolean isEmpty() {
        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new HashTableIterator();
    }

    private class HashTableIterator implements Iterator<T> {
        private int currentIndexInMassive = -1;
        private int currentIndexInList = -1;

        int expectedModCount = modCount;

        public boolean hasNext() {
            for (int i = currentIndexInMassive + 1; i < hashTable.length; i++) {
                if (hashTable[i] != null) {
                    return true;
                }
            }

            return currentIndexInList + 1 < hashTable[currentIndexInMassive].size();
        }

        public T next() {
            T nextElement;

            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (currentIndexInMassive + 1 == hashTable.length && currentIndexInList == -1) {
                throw new NoSuchElementException();
            }

            if (currentIndexInList == -1) {
                ++currentIndexInMassive;

                while (hashTable[currentIndexInMassive] == null) {
                    ++currentIndexInMassive;
                }
            }

            if (currentIndexInList + 2 < hashTable[currentIndexInMassive].size()) {
                ++currentIndexInList;
                nextElement = hashTable[currentIndexInMassive].get(currentIndexInList);
            } else {
                ++currentIndexInList;
                nextElement = hashTable[currentIndexInMassive].get(currentIndexInList);
                currentIndexInList = -1;
            }


            return nextElement;
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T element) {
        int index = Math.abs(element.hashCode() % hashTable.length);

        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();

            hashTable[index].add(element);

            ++modCount;

            return true;
        }

        hashTable[index].add(element);

        ++modCount;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (ArrayList<T> list : hashTable) {
            sb.append("[");

            if (list == null) {
                sb.append("null").append("]").append(", ");
            } else {
                for (T element : list) {
                    sb.append(element).append(", ");
                }

                sb.delete(sb.length() - 2, sb.length());

                sb.append("]").append(", ");
            }
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("]");

        return sb.toString();
    }
}
