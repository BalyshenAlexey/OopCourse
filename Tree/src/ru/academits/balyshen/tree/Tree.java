package ru.academits.balyshen.tree;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Tree<T> {
    private final Comparator<? super T> comparator;
    private TreeNode<T> root;
    private int size;

    public Tree() {
        comparator = null;
    }

    public Tree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    private int compare(T data1, T data2) {
        if (comparator != null) {
            return comparator.compare(data1, data2);
        }

        if (data1 == null && data2 == null) {
            return 0;
        }

        if (data1 == null) {
            return -1;
        }

        if (data2 == null) {
            return 1;
        }

        //noinspection unchecked
        return ((Comparable<? super T>) data1).compareTo(data2);
    }

    public void add(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);

        if (root == null) {
            root = newNode;
            ++size;

            return;
        }

        TreeNode<T> currentNode = root;

        while (true) {
            int comparisonResult = compare(data, currentNode.getData());

            if (comparisonResult < 0) {
                if (currentNode.getLeftNode() != null) {
                    currentNode = currentNode.getLeftNode();

                    continue;
                }

                currentNode.setLeftNode(newNode);
            } else {
                if (currentNode.getRightNode() != null) {
                    currentNode = currentNode.getRightNode();

                    continue;
                }

                currentNode.setRightNode(newNode);
            }

            ++size;

            return;
        }
    }

    public boolean contains(T data) {
        if (root == null) {
            return false;
        }

        TreeNode<T> currentNode = root;

        while (true) {
            int comparisonResult = compare(data, currentNode.getData());

            if (comparisonResult == 0) {
                return true;
            }

            if (comparisonResult < 0) {
                if (currentNode.getLeftNode() != null) {
                    currentNode = currentNode.getLeftNode();

                    continue;
                }
            } else {
                if (currentNode.getRightNode() != null) {
                    currentNode = currentNode.getRightNode();

                    continue;
                }
            }

            return false;
        }
    }

    public boolean deleteByData(T data) {
        TreeNode<T> deletedNode = root;
        TreeNode<T> parentNode = null;
        boolean isLeftChild = true;
        boolean isRoot = true;

        while (true) {
            if (deletedNode == null) {
                return false;
            }

            int comparisonResult = compare(data, deletedNode.getData());

            if (comparisonResult == 0) {
                break;
            }

            if (comparisonResult < 0) {
                isLeftChild = true;
                parentNode = deletedNode;
                deletedNode = deletedNode.getLeftNode();
            } else {
                isLeftChild = false;
                parentNode = deletedNode;
                deletedNode = deletedNode.getRightNode();
            }

            isRoot = false;
        }

        if (deletedNode.getLeftNode() == null && deletedNode.getRightNode() == null) {
            if (isRoot) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeftNode(null);
            } else {
                parentNode.setRightNode(null);
            }
        } else if (deletedNode.getRightNode() == null) {
            if (isRoot) {
                root = deletedNode.getLeftNode();
            } else if (isLeftChild) {
                parentNode.setLeftNode(deletedNode.getLeftNode());
            } else {
                parentNode.setRightNode(deletedNode.getLeftNode());
            }
        } else if (deletedNode.getLeftNode() == null) {
            if (isRoot) {
                root = deletedNode.getRightNode();
            } else if (isLeftChild) {
                parentNode.setLeftNode(deletedNode.getRightNode());
            } else {
                parentNode.setRightNode(deletedNode.getRightNode());
            }
        } else {
            TreeNode<T> minLeftNode = getMinLeftNode(deletedNode);
            minLeftNode.setLeftNode(deletedNode.getLeftNode());

            if (isRoot) {
                root = minLeftNode;
            } else if (isLeftChild) {
                parentNode.setLeftNode(minLeftNode);
            } else {
                parentNode.setRightNode(minLeftNode);
            }
        }

        --size;

        return true;
    }

    private TreeNode<T> getMinLeftNode(TreeNode<T> node) {
        TreeNode<T> minLeftNodeParent = node;
        TreeNode<T> minLeftNode = node.getRightNode();

        while (minLeftNode.getLeftNode() != null) {
            minLeftNodeParent = minLeftNode;
            minLeftNode = minLeftNode.getLeftNode();
        }

        if (minLeftNode != node.getRightNode()) {
            minLeftNodeParent.setLeftNode(minLeftNode.getRightNode());
            minLeftNode.setRightNode(node.getRightNode());
        }

        return minLeftNode;
    }

    public int size() {
        return size;
    }

    public void traverseInWidth(Consumer<T> consumer) {
        if (consumer == null) {
            throw new NullPointerException("Выполняемое действие не должно быть null");
        }

        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();
            consumer.accept(currentNode.getData());

            if (currentNode.getLeftNode() != null) {
                queue.add(currentNode.getLeftNode());
            }

            if (currentNode.getRightNode() != null) {
                queue.add(currentNode.getRightNode());
            }
        }
    }

    public void traverseInDepth(Consumer<T> consumer) {
        if (consumer == null) {
            throw new NullPointerException("Выполняемое действие не должно быть null");
        }

        if (root == null) {
            return;
        }

        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode<T> currentNode = stack.removeLast();
            consumer.accept(currentNode.getData());

            if (currentNode.getRightNode() != null) {
                stack.addLast(currentNode.getRightNode());
            }

            if (currentNode.getLeftNode() != null) {
                stack.addLast(currentNode.getLeftNode());
            }
        }
    }

    public void traverseInDepthRecursively(Consumer<T> consumer) {
        if (consumer == null) {
            throw new NullPointerException("Выполняемое действие не должно быть null");
        }

        if (root == null) {
            return;
        }

        visit(consumer, root);
    }

    private void visit(Consumer<T> consumer, TreeNode<T> node) {
        consumer.accept(node.getData());

        if (node.getLeftNode() != null) {
            visit(consumer, node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            visit(consumer, node.getRightNode());
        }
    }
}
