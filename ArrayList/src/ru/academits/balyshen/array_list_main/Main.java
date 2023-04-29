package ru.academits.balyshen.array_list_main;

import ru.academits.balyshen.array_list.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();

        System.out.println("Создадим пустой список 1: " + arrayList1);
        System.out.println();

        System.out.println("1. Проверка метода add:");
        System.out.println("Вставить в Список 1 значения: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10");

        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("4");
        arrayList1.add("5");
        arrayList1.add("6");
        arrayList1.add("7");
        arrayList1.add("8");
        arrayList1.add("9");
        arrayList1.add("10");

        System.out.println("Список 1 после добавления элементов: " + arrayList1);
        System.out.println();

        int index1 = 10;
        String newElement1 = "12";

        System.out.println("2. Проверка метода add по индексу:");
        System.out.println("Вставить значение " + newElement1 + " по индексу " + index1);

        arrayList1.add(index1, newElement1);

        System.out.println("Список 1 после добавления элементов: " + arrayList1);
        System.out.println();

        System.out.println("3. Проверка метода addAll в конец списка:");

        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("1");
        collection1.add("2");

        System.out.println("Вставить значения коллекции " + collection1);

        if (arrayList1.addAll(collection1)) {
            System.out.println("Список 1 после добавления элементов: " + arrayList1);
            System.out.println();
        } else {
            System.out.println("В список не добавлено новых элементов");
            System.out.println();
        }

        System.out.println("4. Проверка метода addAll по индексу:");

        ArrayList<String> collection2 = new ArrayList<>();
        collection2.add("22");
        collection2.add("23");

        int index2 = 3;

        System.out.println("Вставить значения коллекции " + collection2 + " по индексу " + index2);

        if (arrayList1.addAll(index2, collection2)) {
            System.out.println("Список 1 после добавления элементов: " + arrayList1);
            System.out.println();
        } else {
            System.out.println("В список не добавлено новых элементов");
            System.out.println();
        }

        int capacity = 6;
        ArrayList<String> arrayList2 = new ArrayList<>(capacity);

        arrayList2.add("1");
        arrayList2.add("2");
        arrayList2.add("3");
        arrayList2.add("4");
        arrayList2.add("5");
        arrayList2.add("6");

        System.out.println("Создадим список 2 с вместимостью " + capacity + ": " + arrayList2);
        System.out.println();

        System.out.println("5. Проверка метода clear:");

        arrayList2.clear();

        System.out.println("Список 2 после очистки: " + arrayList2);
        System.out.println();

        System.out.println("6. Проверка метода contains:");

        String searchElement1 = "49";

        System.out.println("Содержит ли Список 1 значение: " + searchElement1 + "?");

        if (arrayList1.contains(searchElement1)) {
            System.out.println("Список 1 содержит значение: " + searchElement1);
            System.out.println();
        } else {
            System.out.println("Искомое значение отсутствует");
            System.out.println();
        }

        System.out.println("7. Проверка метода containsAll:");

        ArrayList<String> collection3 = new ArrayList<>();
        collection3.add("24");
        collection3.add("2");

        System.out.println("Содержит ли Список 1 коллекцию: " + collection3 + "?");

        //noinspection SlowListContainsAll
        if (arrayList1.containsAll(collection3)) {
            System.out.println("Список 1 содержит коллекцию: " + collection3);
            System.out.println();
        } else {
            System.out.println("Искомые значения в Списке 1 отсутствуют");
            System.out.println();
        }

        System.out.println("8. Проверка метода ensureCapacity:");

        int requiredCapacity = 25;

        System.out.println("Присвоить Списку 1 минимальную вместимость: " + requiredCapacity);

        arrayList1.ensureCapacity(requiredCapacity);

        System.out.println("Список 1: " + arrayList1);
        System.out.println();

        System.out.println("9. Проверка метода get:");

        int searchIndex = 14;

        System.out.println("Получить из Списка 1 значение по индексу: " + searchIndex);
        System.out.println("Значение по индексу " + searchIndex + ": " + arrayList1.get(searchIndex));
        System.out.println();

        System.out.println("10. Проверка метода indexOf:");

        String searchElement2 = "2";

        System.out.println("Получить из Списка 1 первый индекс значения: " + searchElement2);

        int firstIndex = arrayList1.indexOf(searchElement2);

        if (firstIndex != -1) {
            System.out.println("Первый индекс значения " + searchElement2 + ": " + firstIndex);
            System.out.println();
        } else {
            System.out.println("Значение " + searchElement2 + " в списке отсутствует");
            System.out.println();
        }

        System.out.println("11. Проверка метода isEmpty:");

        if (arrayList1.isEmpty()) {
            System.out.println("Список пуст");
            System.out.println();
        } else {
            System.out.println("В Списке есть значения");
            System.out.println();
        }

        System.out.println("12. Проверка метода iterator:");
        System.out.println("Распечатаем значения из Списка 1 используя итератор");

        for (String s : arrayList1) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("13. Проверка метода lastIndexOf:");

        String searchElement3 = "2";

        System.out.println("Получить из Списка 1 последний индекс значения: " + searchElement3);

        int lastIndex = arrayList1.lastIndexOf(searchElement3);

        if (lastIndex != -1) {
            System.out.println("Последний индекс значения " + searchElement3 + ": " + lastIndex);
            System.out.println();
        } else {
            System.out.println("Значение " + searchElement3 + " в списке отсутствует");
            System.out.println();
        }

        System.out.println("14. Проверка метода remove по индексу:");

        int removedElementIndex = 1;

        System.out.println("Удалить из Списка 1 элемент с индексом: " + removedElementIndex);

        System.out.println("Из списка 1 удалено значение: " + arrayList1.remove(removedElementIndex));
        System.out.println("Список 1: " + arrayList1);
        System.out.println();

        System.out.println("15. Проверка метода remove по значению:");

        String removedElement = "10";

        System.out.println("Удалить из Списка 1 значение: " + removedElement);

        if (arrayList1.remove(removedElement)) {
            System.out.println("Список 1: " + arrayList1);
            System.out.println();
        } else {
            System.out.println("Указанное значение в списке отсутствует");
            System.out.println();
        }

        System.out.println("16. Проверка метода removeAll:");
        System.out.println("Удалить из Списка 1 значения коллекции: " + collection3);

        if (arrayList1.removeAll(collection3)) {
            System.out.println("Из списка 1 удалены значения содержащиеся в коллекции: " + collection3);
            System.out.println("Список 1: " + arrayList1);
            System.out.println();
        } else {
            System.out.println("Указанные значения в списке отсутствует");
            System.out.println("Список 1: " + arrayList1);
            System.out.println();
        }

        System.out.println("17. Проверка метода retainAll:");
        System.out.println("Удалить из Списка 1 все значения не встречающиеся в коллекции " + collection2);

        if (arrayList1.retainAll(collection2)) {
            System.out.println("Список 1 после удаления значений не встречающихся в переданной коллекции: " + arrayList1);
            System.out.println();
        } else {
            System.out.println("В Списке 1 не содержатся значения из переданной коллекции");
            System.out.println("Список 1: " + arrayList1);
            System.out.println();
        }

        System.out.println("18. Проверка метода set:");

        int setIndex = 1;
        String newElement2 = "25";

        System.out.println("Заменить в Списке 1 элемент по индексу " + setIndex + " на " + newElement2);

        System.out.println("Старое значение " + arrayList1.set(setIndex, newElement2));

        System.out.println("Список 1: " + arrayList1);
        System.out.println();

        System.out.println("19. Проверка метода size:");
        System.out.println("Размер Списка 1 : " + arrayList1.size());
        System.out.println();

        System.out.println("20. Проверка метода toArray:");

        String[] array = arrayList1.toArray(new String[1]);

        System.out.println("Массив из списка 1: " + Arrays.toString(array));
        System.out.println();

        System.out.println("21. Проверка метода trimToSize:");
        System.out.println("Урезать размер массива до размера Списка 1");

        arrayList1.trimToSize();

        System.out.println("Список 1: " + arrayList1);
        System.out.println();
    }
}
