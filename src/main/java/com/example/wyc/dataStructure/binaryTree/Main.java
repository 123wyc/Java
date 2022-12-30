package com.example.wyc.dataStructure.binaryTree;

public class Main {

    public static void main(String[] args) {
        //创建一个二叉树对象
        BinaryTree binaryTree = new BinaryTree();

        //创建结点对象
        PlayerNode root = new PlayerNode(1, "梅西");
        PlayerNode node2 = new PlayerNode(2, "内马尔");
        PlayerNode node3 = new PlayerNode(3, "阿圭罗");
        PlayerNode node4 = new PlayerNode(4, "范佩西");
        PlayerNode node5 = new PlayerNode(5, "罗本");

        //创建该二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("前序遍历no.2");
        binaryTree.preOrder(binaryTree.getRoot());

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("中序遍历.2");
        binaryTree.infixOrder(binaryTree.getRoot());

        System.out.println("后序遍历");
        binaryTree.postOrder();

        System.out.println("后序遍历.2");
        binaryTree.postOrder(binaryTree.getRoot());
    }
}
