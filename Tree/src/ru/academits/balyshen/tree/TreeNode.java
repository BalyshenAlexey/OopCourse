package ru.academits.balyshen.tree;

class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftNode() {
        return left;
    }

    public void setLeftNode(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRightNode() {
        return right;
    }

    public void setRightNode(TreeNode<T> right) {
        this.right = right;
    }
}
