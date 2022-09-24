package ru.academits.balyshen.array_list;

import java.util.Collection;
import java.util.Iterator;

public interface MyList<T> {

    boolean add();

    void add(int index, T element);

    boolean addAll(Collection<? extends T> c);

    boolean addAll(int index, Collection<? extends T> c);

    void clear();

    Object clone();

    boolean contains();

    void ensureCapacity(int minCapacity);

    T get();

    int indexOf();

    boolean isEmpty();

    Iterator<T> iterator();

    int lastIndexOf();

    T remove(int index);

    boolean remove(T element);

    boolean removeAll(Collection<?> c);

    void removeRange(int fromIndex, int toIndex);

    boolean retainAll(Collection<?> c);

    T set(int index, T element);

    int size();

    T[] toArray();

    void trimToSize();
}
