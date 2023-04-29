package ru.academits.balyshen.tree;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Tree<T> {
    private TreeNode<T> root;
    private final Comparator<? super T> comparator;
    private int size;

    public Tree() {
        comparator = null;
    }

    public Tree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    private int compare(T data1, T data2) {
        Comparator<? super T> comparator = this.comparator;

        if (comparator == null) {
            return ((Comparable<? super T>) data1).compareTo(data2);
        }

        return comparator.compare(data1, data2);
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

    public void traversalTreeByWidthTraversal(Consumer<T> action) {
        if (action == null) {
            throw new NullPointerException("Выполняемое действие не должно быть null");
        }

        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> currentNode = queue.remove();
            action.accept(currentNode.getData());

            if (currentNode.getLeftNode() != null) {
                queue.add(currentNode.getLeftNode());
            }

            if (currentNode.getRightNode() != null) {
                queue.add(currentNode.getRightNode());
            }
        }
    }

    public void traversalTreeByDepthTraversal(Consumer<T> action) {
        if (action == null) {
            throw new NullPointerException("Выполняемое действие не должно быть null");
        }

        if (root == null) {
            return;
        }

        Deque<TreeNode<T>> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode<T> currentNode = stack.removeLast();
            action.accept(currentNode.getData());

            if (currentNode.getRightNode() != null) {
                stack.addLast(currentNode.getRightNode());
            }

            if (currentNode.getLeftNode() != null) {
                stack.addLast(currentNode.getLeftNode());
            }
        }
    }

    public void traversalTreeByDepthTraversalWithRecursion(Consumer<T> action) {
        if (action == null) {
            throw new NullPointerException("Выполняемое действие не должно быть null");
        }

        if (root == null) {
            return;
        }

        visit(action, root);
    }

    private void visit(Consumer<T> action, TreeNode<T> node) {
        action.accept(node.getData());

        if (node.getLeftNode() != null) {
            visit(action, node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            visit(action, node.getRightNode());
        }
    }
}
