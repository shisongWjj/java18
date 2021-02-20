package com.ss.dataStructures.tree;

/**
 * BST
 * 二分搜索树
 *
 * @author shisong
 * @date 2019/4/25
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        //存储的数据
        public E e;
        //右孩子
        public Node right;
        //左孩子
        public Node left;

        public Node(E e) {
            this.e = e;
            right = null;
            left = null;
        }
    }

    //树中元素的个数
    private int size;
    //数的根节点
    private Node root;

    /**
     * 获取数中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素 方式一
     * @param e
     */
    /*public void add(E e){
        //如果根节点为空，则直接在根节点上赋值
        if(root == null){
            root = new Node(e);
            size++;
        }else{
            add(root,e);
        }
    }

    *//**
     * 递归方法，在某个节点上 添加值
     * @param node
     * @param e
     *//*
    private void add(Node node, E e) {
        //结束递归的条件
        if(e.equals(node.e)){
            //1.当 当前节点的值与传入的值相等时，递归结束
            return;
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            //2.当 当前传入的值比该节点的值小， 并且 该节点的右节点为null
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right  == null){
            //2.当 当前传入的值比该节点的值大， 并且 该节点的左节点为null
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }*/

    /**
     * 添加元素 方式二
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 递归方法，在某个节点上 添加值
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        //结束递归的条件
        if (node == null) {
            //当 当前节点为null的时候，添加元素
            node = new Node(e);
            size++;
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归查找 是否包含某个元素
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            //当节点为空时，返回false
            return false;
        } else if (e.equals(node.e)) {
            //当值相等时，返回true
            return true;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历  递归
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历  递归
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.e);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历 递归
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.e);
        }
    }

}
