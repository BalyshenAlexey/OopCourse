package ru.academits.balyshen.array_list;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private T[] items;
    private int length;
    private int modCount = 0;


    @Override
    public boolean add() {
        return false;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public boolean contains() {
        return false;
    }

    @Override
    public void ensureCapacity(int minCapacity) {

    }

    @Override
    public T get() {
        return null;
    }

    @Override
    public int indexOf() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public int lastIndexOf() {
        return 0;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public void trimToSize() {

    }
}
