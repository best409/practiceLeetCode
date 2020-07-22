package com.test;

/**
 * 参考文献：
 * [1]  labuladong. 数据结构和算法学习指南[M]. 微信公众号, 2020.
 * @author: zhangycl
 * @date: 2020/7/22
 * @description:
 *          1、数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储），
 *          各种数据结构的遍历 + 访问无非两种形式：线性和非线性。
 *              1. 线性就是 for/while 迭代为代表
 *              2. 非线性就是 递归 为代表。
 *          2、数据结构是工具，算法是通过合适的工具解决特定问题的方法。
 *              1. 先刷二叉树，二叉树最容易培养框架思维，大部分算法技巧，本质上都是树的遍历问题。
 *              2. 只要涉及递归问题，都是树的问题。
 *          3、总结
 *              1. 数据结构的基本存储方式就是链表和顺序两种，基本操作就是增删改查，遍历方式无非迭代和递归。
 *              2. 刷算法题建议从【树】分类开始刷，结合框架思维，通过刷二叉树专题把树结构理解到位，然后再去看回溯、动归、分治等算法专题。
 */
public class BinaryTreeFramework {

    /*
    * 1、数组遍历框架，典型的线性迭代结构
    * */
    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //迭代访问 arr[i]
        }
    }


    /*
    * 2、链表遍历框架，兼具迭代和递归结构
    * */

    /*基本的单链表节点*/
    class ListNode {
        int val;
        ListNode next;
    }

    /*迭代访问*/
    void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            //迭代访问 p.val
        }
    }

    /*递归访问*/
    void traverse1(ListNode head) {
        //递归访问 head.val
        traverse1(head.next);
    }


    /*
    * 3、二叉树遍历框架，典型的非线性递归遍历结构
    * */
    /*基本的二叉树节点*/
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    void traverse(TreeNode root) {
        //前序遍历
        traverse(root.left);
        //中序遍历
        traverse(root.right);
        //后序遍历
    }


    /*
    * 4、二叉树框架扩展为 N 叉树的遍历框架
    * */
    /*基本的 N 叉树节点*/
    class NTreeNode {
        int val;
        NTreeNode[] children;
    }

    void traverse(NTreeNode root) {
        for (NTreeNode child : root.children) {
            traverse(child);
        }
    }

}
