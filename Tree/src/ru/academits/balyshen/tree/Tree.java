package ru.academits.balyshen.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree<T> {
    private TreeNode<T> rootNode;

    public Tree() {
        rootNode = null;
    }

    public void addNode(T data) {
        TreeNode<T> newNode = new TreeNode<>();
        newNode.setData(data);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            TreeNode<T> currentNode = rootNode;

            while (true) {
                int comparator = ((Comparable<? super T>) data).compareTo(currentNode.getData());

                if (comparator < 0) {
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

                return;
            }
        }
    }

    public boolean findNodeByData(T data) {
        TreeNode<T> currentNode = rootNode;

        while (true) {
            int comparator = ((Comparable<? super T>) data).compareTo(currentNode.getData());

            if (comparator == 0) {
                return true;
            }

            if (comparator < 0) {
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

    public boolean deleteNodeByData(T data) {
        if (((Comparable<? super T>) data).compareTo(rootNode.getData()) == 0) {
            rootNode = null;
            return true;
        }

        TreeNode<T> currentNode = rootNode;
        TreeNode<T> parentNode = rootNode;
        boolean isLeftChild = true;

        while (true) {
            if (currentNode == null) {
                return false;
            }

            int comparator = ((Comparable<? super T>) data).compareTo(currentNode.getData());

            if (comparator == 0) {
                break;
            }

            if (comparator < 0) {
                isLeftChild = true;
                parentNode = currentNode;
                currentNode = currentNode.getLeftNode();
            } else {
                isLeftChild = false;
                parentNode = currentNode;
                currentNode = currentNode.getRightNode();
            }
        }

        if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
            if (isLeftChild) {
                parentNode.setLeftNode(null);
            } else {
                parentNode.setRightNode(null);
            }
        } else if (currentNode.getRightNode() == null) {
            if (isLeftChild) {
                parentNode.setLeftNode(currentNode.getLeftNode());
            } else {
                parentNode.setRightNode(currentNode.getLeftNode());
            }
        } else if (currentNode.getLeftNode() == null) {
            if (isLeftChild) {
                parentNode.setLeftNode(currentNode.getRightNode());
            } else {
                parentNode.setRightNode(currentNode.getRightNode());
            }
        } else {
            TreeNode<T> minLeftNode = receiveMinLeftNode(currentNode);
            minLeftNode.setLeftNode(currentNode.getLeftNode());

            if (isLeftChild) {
                parentNode.setLeftNode(minLeftNode);
            } else {
                parentNode.setRightNode(minLeftNode);
            }
        }

        return true;
    }

    private TreeNode<T> receiveMinLeftNode(TreeNode<T> node) {
        TreeNode<T> minLeftNodeParent = node;
        TreeNode<T> minLeftNode = node;
        TreeNode<T> currentNode = node.getRightNode();

        while (currentNode != null) {
            minLeftNodeParent = minLeftNode;
            minLeftNode = currentNode;
            currentNode = currentNode.getLeftNode();
        }

        if (minLeftNode != node.getRightNode()) {
            minLeftNodeParent.setLeftNode(minLeftNode.getRightNode());
            minLeftNode.setRightNode(node.getRightNode());
        }

        return minLeftNode;
    }

    public int getElementsCount() {
        int elementsCount = 0;
        Queue<TreeNode<T>> queue = new LinkedList<>();

        queue.add(rootNode);

        while (queue.peek() != null) {
            TreeNode<T> currentNode = queue.remove();
            ++elementsCount;

            if (currentNode.getLeftNode() != null) {
                queue.add(currentNode.getLeftNode());
            }

            if (currentNode.getRightNode() != null) {
                queue.add(currentNode.getRightNode());
            }
        }

        return elementsCount;
    }

    public String printTreeByWidthTraversal() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(rootNode);

        while (queue.peek() != null) {
            TreeNode<T> currentNode = queue.remove();
            sb.append(currentNode.getData()).append(", ");

            if (currentNode.getLeftNode() != null) {
                queue.add(currentNode.getLeftNode());
            }

            if (currentNode.getRightNode() != null) {
                queue.add(currentNode.getRightNode());
            }
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    public String printTreeByDepthTraversalWithoutRecursion() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.empty()) {
            TreeNode<T> currentNode = stack.pop();
            sb.append(currentNode.getData()).append(", ");

            if (currentNode.getRightNode() != null) {
                stack.push(currentNode.getRightNode());
            }

            if (currentNode.getLeftNode() != null) {
                stack.push(currentNode.getLeftNode());
            }
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    public String printTreeByDepthTraversalWithRecursion() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(treeToString(rootNode));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    private String treeToString(TreeNode<T> node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.getData()).append(", ");

        if (node.getLeftNode() != null) {
            sb.append(treeToString(node.getLeftNode()));
        }

        if (node.getRightNode() != null) {
            sb.append(treeToString(node.getRightNode()));
        }

        return sb.toString();
    }
}
