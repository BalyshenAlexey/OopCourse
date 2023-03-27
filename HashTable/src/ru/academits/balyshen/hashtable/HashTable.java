package ru.academits.balyshen.hashtable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private final ArrayList<T>[] hashTable;
    private int modCount;

    public HashTable() {
        hashTable = new ArrayList[DEFAULT_CAPACITY];
    }

    public HashTable(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Некорректная размерность: " + initialCapacity + ". Введите значение больше 0.");
        }

        hashTable = new ArrayList[initialCapacity];
    }

    @Override
    public int size() {
        int elementsCount = 0;

        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                elementsCount += list.size();
            }
        }

        return elementsCount;
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
    public boolean add(T element) {
        int index = Math.abs(element.hashCode() % hashTable.length);

        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }

        hashTable[index].add(element);

        ++modCount;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection.size() == 0) {
            return false;
        }

        for (T item : collection) {
            add(item);
        }

        return true;
    }

    @Override
    public boolean contains(Object object) {
        int index = Math.abs(object.hashCode() % hashTable.length);

        if (hashTable[index] == null) {
            return false;
        } else {
            return hashTable[index].contains(object);
        }
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

    @Override
    public boolean remove(Object object) {
        int index = Math.abs(object.hashCode() % hashTable.length);

        if (hashTable[index] == null) {
            return false;
        }

        if (hashTable[index].contains(object)) {
            if (hashTable[index].size() == 1) {
                hashTable[index] = null;

                ++modCount;

                return true;
            }

            if (hashTable[index].remove(object)) {
                ++modCount;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
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

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    if (!collection.contains(hashTable[i].get(j))) {
                        if (hashTable[i].size() == 1) {
                            hashTable[i] = null;

                            ++modCount;
                            isDeleted = true;

                            break;
                        } else {
                            hashTable[i].remove(j);

                            --j;
                            ++modCount;
                            isDeleted = true;
                        }
                    }
                }
            }
        }

        return isDeleted;
    }

    @Override
    public void clear() {
        Arrays.fill(hashTable, null);
        ++modCount;
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
            if (currentIndexInList == -1) {
                for (int i = currentIndexInMassive + 1; i < hashTable.length; i++) {
                    if (hashTable[i] != null) {
                        if (currentIndexInList + 1 < hashTable[i].size()) {
                            return true;
                        }
                    }
                }
            } else {
                return currentIndexInList + 1 < hashTable[currentIndexInMassive].size();
            }

            return false;
        }

        public T next() {
            T nextElement;

            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("Ошибка! Текущий список изменен.");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("Ошибка! В списке больше нет элементов.");
            }

            if (currentIndexInList == -1) {
                do {
                    ++currentIndexInMassive;
                } while (hashTable[currentIndexInMassive] == null);
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
        int elementsCount = size();
        Object[] array = new Object[elementsCount];

        int currentPositionInArray = 0;

        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                System.arraycopy(list.toArray(), 0, array, currentPositionInArray, list.size());
                currentPositionInArray += list.size();
            }
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] array) {
        int elementsCount = size();

        if (array.length < elementsCount) {
            array = Arrays.copyOf(array, elementsCount);
        }

        int currentPositionInArray = 0;

        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                System.arraycopy(list.toArray(), 0, array, currentPositionInArray, list.size());
                currentPositionInArray += list.size();
            }
        }

        return array;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for (ArrayList<T> list : hashTable) {
            sb.append('[');

            if (list == null) {
                sb.append("null").append(']').append(", ");
            } else {
                for (T element : list) {
                    sb.append(element).append(", ");
                }

                sb.delete(sb.length() - 2, sb.length());

                sb.append(']').append(", ");
            }
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append(']');

        return sb.toString();
    }
}
