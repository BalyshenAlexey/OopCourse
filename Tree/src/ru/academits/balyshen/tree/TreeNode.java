package ru.academits.balyshen.tree;

class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode (T data){
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftNode() {
        return this.left;
    }

    public void setLeftNode(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRightNode() {
        return this.right;
    }

    public void setRightNode(TreeNode<T> right) {
        this.right = right;
    }
}
