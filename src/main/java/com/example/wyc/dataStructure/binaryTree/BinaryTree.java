package com.example.wyc.dataStructure.binaryTree;

//定义一个二叉树
public class BinaryTree {

    private PlayerNode root; //根节点

    public void setRoot(PlayerNode root) {
        this.root = root;
    }

    public PlayerNode getRoot() {
        return root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void preOrder(PlayerNode node) {

        if( null==node){
            return ;
        }
        System.out.println(node.toString());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void infixOrder(PlayerNode node) {

        if( null==node){
            return ;
        }
        infixOrder(node.getLeft());
        System.out.println(node.toString());
        infixOrder(node.getRight());
    }
    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(PlayerNode node) {
        if( null==node){
            return ;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.toString());
    }
}


//先创建HeroNode 结点
class PlayerNode {
    private int no;
    private String name;
    private PlayerNode left; //默认为null
    private PlayerNode right;

    public PlayerNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerNode getLeft() {
        return left;
    }

    public void setLeft(PlayerNode left) {
        this.left = left;
    }

    public PlayerNode getRight() {
        return right;
    }

    public void setRight(PlayerNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "PlayerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);  //先输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历的方法
    public void infixOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);  //输出父节点
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历的方法
    public void postOrder() {
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);  //输出父节点
    }
}