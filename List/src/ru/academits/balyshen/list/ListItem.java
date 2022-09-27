package ru.academits.balyshen.list;

class ListItem<T> {
    private T data;
    private ListItem<T> next;

    protected ListItem(T data) {
        this.data = data;
    }

    protected ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    protected T getData() {
        return data;
    }

    protected void setData(T data) {
        this.data = data;
    }

    protected ListItem<T> getNext() {
        return next;
    }

    protected void setNext(ListItem<T> next) {
        this.next = next;
    }
}
