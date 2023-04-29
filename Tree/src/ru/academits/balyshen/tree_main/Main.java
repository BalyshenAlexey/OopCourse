package ru.academits.balyshen.tree_main;

import ru.academits.balyshen.tree.Tree;

import java.util.Comparator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree1 = new Tree<>();

        System.out.println("В дерево 1 добавлены значения: 100, 50, 60, 40, 75, 200, 150, 140, 170, 155, 202, 201, 225, 275, 215, 220");
        System.out.println();

        tree1.add(100);
        tree1.add(50);
        tree1.add(60);
        tree1.add(40);
        tree1.add(75);
        tree1.add(200);
        tree1.add(150);
        tree1.add(140);
        tree1.add(170);
        tree1.add(155);
        tree1.add(202);
        tree1.add(201);
        tree1.add(225);
        tree1.add(275);
        tree1.add(215);
        tree1.add(220);

        Consumer<Integer> printTreeElement = treeElement -> System.out.print(treeElement + " ");

        System.out.print("Распечатаем дерево 1 используя обход в ширину: ");

        tree1.traversalTreeByWidthTraversal(printTreeElement);

        System.out.println();
        System.out.println();

        System.out.print("Распечатаем дерево 1 используя обход в глубину без рекурсии: ");

        tree1.traversalTreeByDepthTraversal(printTreeElement);

        System.out.println();
        System.out.println();

        System.out.print("Распечатаем дерево 1 используя обход в глубину с рекурсией: ");

        tree1.traversalTreeByDepthTraversalWithRecursion(printTreeElement);

        System.out.println();
        System.out.println();

        System.out.println("1. Проверка метода findNodeByData: ");

        Integer searchElement = 200;

        System.out.println("Содержится ли в дереве 1 элемент: " + searchElement + "?");

        if (tree1.contains(searchElement)) {
            System.out.println("Искомый элемент содержится в дереве");
            System.out.println();
        } else {
            System.out.println("Искомый элемент отсуствует");
            System.out.println();
        }

        System.out.println("2. Проверка метода deleteNodeByData: ");

        Comparator<Integer> comparator = Integer::compareTo;

        Tree<Integer> tree2 = new Tree<>(comparator);

        System.out.println("В дерево 2 добавлены значения: 100, 50, 60, 40, 75, 200");
        System.out.println();

        tree1.add(100);
        tree1.add(50);
        tree1.add(60);
        tree1.add(40);
        tree1.add(75);
        tree1.add(200);

        Integer deletedElement = 200;

        System.out.println("Удалить из дерева 2 элемент: " + deletedElement);

        if (tree1.deleteByData(deletedElement)) {
            System.out.println("Искомый элемент удален");
            System.out.print("Распечатаем дерево 2 после удаления используя обход в ширину: ");

            tree2.traversalTreeByWidthTraversal(printTreeElement);

            System.out.println();
            System.out.println();
        } else {
            System.out.println("Искомый элемент отсуствует");
            System.out.println();
        }

        System.out.println("3. Проверка метода getElementsCount: ");
        System.out.println("В дереве 1 содержится " + tree1.size() + " элементов");
    }
}
