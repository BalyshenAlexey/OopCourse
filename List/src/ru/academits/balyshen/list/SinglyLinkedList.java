package ru.academits.balyshen.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    public SinglyLinkedList(ListItem<T> head, int count) {
        this.head = head;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        ++count;
    }

    public T getDataByIndex(int index) {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            if (index < 0 || index > count - 1) {
                throw new IllegalArgumentException();
            }

            ListItem<T> item = head;
            int i = 0;

            while (i != index) {
                item = item.getNext();

                i++;
            }

            return item.getData();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! Некорректный индекс. Введите значение от 0 до " + (count - 1) + ".");

            return null;
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");

            return null;
        }
    }

    public T changeDataByIndex(int index, T data) {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            if (index < 0 || index > count - 1) {
                throw new IllegalArgumentException();
            }

            ListItem<T> item = head;
            int i = 0;

            while (i != index) {
                item = item.getNext();

                i++;
            }

            T itemData = item.getData();
            item.setData(data);

            return itemData;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! Некорректный индекс. Введите значение от 0 до " + (count - 1) + ".");

            return null;
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");

            return null;
        }
    }

    public T deleteItemByIndex(int index) {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            if (index < 0 || index > count - 1) {
                throw new IllegalArgumentException();
            }

            if (index == 0) {
                return deleteFirst();
            }

            ListItem<T> item = head;
            int i = 1;

            while (i != index) {
                item = item.getNext();

                i++;
            }

            T itemData = item.getNext().getData();
            item.setNext(item.getNext().getNext());

            --count;

            return itemData;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! Некорректный индекс. Введите значение от 0 до " + (count - 1) + ".");

            return null;
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");

            return null;
        }
    }


    public void addItemByIndex(int index, T data) {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            if (index < 0 || index > count - 1) {
                throw new IllegalArgumentException();
            }

            if (index == 0) {
                addFirst(data);
            } else {
                ListItem<T> item = head;
                int i = 0;
                int previousIndex = index - 1;

                while (i != previousIndex) {
                    item = item.getNext();

                    i++;
                }

                ListItem<T> newItem = new ListItem<>(data, item.getNext());
                item.setNext(newItem);

                ++count;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка! Некорректный индекс. Введите значение от 0 до " + (count - 1) + ".");
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");
        }
    }

    public boolean deleteItemByData(T data) {
        if (head == null) {
            return false;
        }

        boolean isDeleted;

        do {
            if (head.getData().equals(data)) {
                head = head.getNext();

                --count;
                isDeleted = true;
            } else {
                isDeleted = false;
            }
        } while (isDeleted);


        for (ListItem<T> item = head.getNext(), previousItem = head; item != null; ) {
            if (item.getData().equals(data)) {
                previousItem.setNext(item.getNext());
                item = item.getNext();

                --count;

                isDeleted = true;
            } else {
                previousItem = item;
                item = item.getNext();
            }

        }

        return isDeleted;
    }

    public T deleteFirst() {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            T headData = head.getData();
            head = head.getNext();

            --count;

            return headData;
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");

            return null;
        }
    }

    public void reverse(SinglyLinkedList<T> list) {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            SinglyLinkedList<T> revLinkedList = new SinglyLinkedList<>();

            for (int i = 0; i < count; i++) {
                revLinkedList.addFirst((list.getDataByIndex(i)));
            }

            head = revLinkedList.getHead();
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");
        }
    }

    public SinglyLinkedList<T> copy() {
        try {
            if (head == null) {
                throw new NullPointerException();
            }

            ListItem<T> item = head;

            ListItem<T> copyHead = new ListItem<>(item.getData(), null);
            ListItem<T> copyTail = copyHead;

            item = item.getNext();

            while (item != null) {
                copyTail.setNext(new ListItem<>());
                copyTail = copyTail.getNext();
                copyTail.setData(item.getData());
                copyTail.setNext(null);

                item = item.getNext();
            }

            return new SinglyLinkedList<>(copyHead, count);
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Передан пустой список.");

            return null;
        }
    }

    @Override
    public String toString() {
        ListItem<T> p = head;

        if (p == null) {

            return "В списке нет значений.";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (; p != null; p = p.getNext()) {
            sb.append(p.getData().toString()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append("]");

        return sb.toString();
    }
}
