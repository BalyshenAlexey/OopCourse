package ru.academits.balyshen.array_list;

import java.util.Collection;
import java.util.Iterator;

interface MyList<T> {
    boolean add(T element);

    void add(int index, T element);

    boolean addAll(Collection<? extends T> collection);

    boolean addAll(int index, Collection<? extends T> collection);

    void clear();

    boolean contains(T element);

    void ensureCapacity(int requiredCapacity);

    T get(int index);

    int indexOf(T element);

    boolean isEmpty();

    Iterator<T> iterator();

    int lastIndexOf(T element);

    T remove(int index);

    boolean remove(T data);

    boolean removeAll(Collection<? extends T> collection);

    void removeRange(int fromIndex, int toIndex);

    boolean retainAll(Collection<? extends T> collection);

    T set(int index, T element);

    int size();

    T[] toArray(T[] array);

    void trimToSize();
}
