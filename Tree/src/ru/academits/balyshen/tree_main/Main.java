package ru.academits.balyshen.tree_main;

import ru.academits.balyshen.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();

        System.out.println("В дерево добавлены значения: 100, 50, 200, 150, 140, 170, 155, 200, 225, 275, 215, 220");
        System.out.println();

        tree.addNode("100");
        tree.addNode("50");
        tree.addNode("200");
        tree.addNode("150");
        tree.addNode("140");
        tree.addNode("170");
        tree.addNode("155");
        tree.addNode("200");
        tree.addNode("225");
        tree.addNode("275");
        tree.addNode("215");
        tree.addNode("220");


        System.out.println("Распечатаем дерево используя обход в ширину: " + tree.printTreeByWidthTraversal());
        System.out.println();

        System.out.println("Распечатаем дерево используя обход в глубину с рекурсией: " + tree.printTreeByDepthTraversalWithRecursion());
        System.out.println();

        System.out.println("Распечатаем дерево используя обход в глубину без рекурсии: " + tree.printTreeByDepthTraversalWithoutRecursion());
        System.out.println();

        System.out.println("1. Проверка метода findNodeByData: ");

        String searchElement1 = "200";

        System.out.println("Содержится ли в дереве элемент: " + searchElement1 + "?");

        if (tree.findNodeByData(searchElement1)) {
            System.out.println("Искомый элемент содержится в дереве");
            System.out.println();
        } else {
            System.out.println("Искомый элемент отсуствует");
            System.out.println();
        }

        System.out.println("2. Проверка метода deleteNodeByData: ");

        String deletedElement1 = "200";

        System.out.println("Удалить из дерева элемент: " + deletedElement1);

        if (tree.deleteNodeByData(deletedElement1)) {
            System.out.println("Искомый элемент удален");
            System.out.println("Распечатаем дерево после удаления используя обход в ширину: " + tree.printTreeByWidthTraversal());
            System.out.println();
        } else {
            System.out.println("Искомый элемент отсуствует");
            System.out.println();
        }

        System.out.println("3. Проверка метода getElementsCount: ");
        System.out.println("В дереве содержится " + tree.getElementsCount() + " элементов");
    }
}
