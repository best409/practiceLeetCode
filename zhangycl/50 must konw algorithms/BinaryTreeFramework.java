package com.test;


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 参考文献：
 * [1]  labuladong. 二叉树的题，就那几个框架，枯燥至极[M]. 微信公众号, 2020.
 * @author: zhangycl
 * @date: 2020/7/23
 * @description:
 *          1、总结二叉树的前、中、后学遍历、层级遍历的框架
 *          以序列化和反序列化为例：
 *          实现序列化：前中后序遍历
 *          实现反序列化：前（root在开头）、后（root在结尾）、层级遍历（root在头）、（中序无法实现反序列化，因为无法确定root的位置）
 */
public class BinaryTreeFramework {


    /*基本的二叉树节点*/
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    /*
     * 前、中、后序遍历框架
     * 层级遍历框架
     * */
    /*1、前序遍历框架*/
    void traverseBefore(TreeNode root) {
        if (root == null) return;

        //前序遍历的代码

        traverseBefore(root.left);
        traverseBefore(root.right);

    }

    /*2、后序遍历框架*/
    void traverseAfter(TreeNode root) {
        if (root == null) return;
        traverseAfter(root.left);
        traverseAfter(root.right);

        //后序遍历的代码
    }


    /*3、中序遍历框架*/
    void traverseMiddle(TreeNode root) {
        if(root == null) return;

        traverseMiddle(root.left);

        //中序遍历的代码

        traverseMiddle(root.right);
    }

    /*4、层级遍历二叉树框架*/
    void traverseLevel(TreeNode root) {
        if (root == null) return;
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (! q.isEmpty()) {
            TreeNode cur = q.poll();

            //层级遍历代码位置

            if (cur.left != null) {
                q.offer(cur.left);
            }

            if(cur.right != null) {
                q.offer(cur.right);
            }
        }



    }


    /*
    * 1.1 二叉树序列化：将二叉树【打平】到一个列表中
    */
    LinkedList<Integer> res;
    void traverse(TreeNode root) {
        if (root == null) {
            //暂且用数字 -1 代表空指针 null
            res.addLast(-1);
            return;
        }

        //前序遍历位置
        res.addLast(root.val);

        traverse(root.left);
        traverse(root.right);
    }


    /*
    * 1.2 二叉树序列化：将二叉树【打平】到一个字符串中
    * 分别利用前序、中序、后序，将二叉树序列化为字符串，注意：中序遍历形成的字符串，无法进行反序列化
    */
    /*代表分隔符的字符*/
    String SEP = ",";
    /*代表 null 空指针的字符*/
    String NULL = "#";
    /*主函数，将二叉树序列化为字符串*/
    String serialize(TreeNode root) {
        //用于拼接字符串
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /*辅助函数，将二叉树打平为字符串，存入StringBuilder*/
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /*************前序遍历位置**********/
        sb.append(root.val).append(SEP);
        /**********************************/

        serialize(root.left,sb);


        /*************中序遍历位置**********/
        //sb.append(root.val).append(SEP);
        /**********************************/

        serialize(root.right,sb);

        /*************后序遍历位置**********/
        //sb.append(root.val).append(SEP);
        /**********************************/
    }

    /*
    * 1.3 利用前序 ---> 字符串反序列化：用字符串构建二叉树
    * */
    /*String data = "1,2,#,4,#,#,3,#,#,";
    String[] nodes = data.split(",");*/

    /*主函数，将字符串反序列化为二叉树结构*/
    TreeNode deserializeBefore(String data) {
        //将字符串转化成列表
        LinkedList<String> nodes  = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializeBefore(nodes);
    }

    /*辅助函数，通过 nodes 列表构造二叉树*/
    TreeNode deserializeBefore(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        //前序遍历位置
        //列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserializeBefore(nodes);
        root.right = deserializeBefore(nodes);

        return root;
    }


    /*
     * 2.1 利用后序 ---> 字符串反序列化：用字符串构建二叉树
     * */
    /*
    前序
    String data = "1,2,#,4,#,#,3,#,#,";
    String[] nodes = data.split(",");
    后序
    String data = "#,#,#,4,2,#,#,3,3,1,";
    String[] nodes = data.split(",");
    */

    /*主函数，将字符串反序列化为二叉树结构*/
    TreeNode deserializeAfter(String data) {
        //将字符串转化成列表
        LinkedList<String> nodes  = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializeAfter(nodes);
    }

    /*辅助函数，通过 nodes 列表构造二叉树*/
    TreeNode deserializeAfter(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        //后序遍历形成的列表，根节点在最右侧
        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        //先构造右子树，再构造左子树
        root.right = deserializeAfter(nodes);
        root.left = deserializeAfter(nodes);

        return root;
    }


    /*
     * 4.1 利用层级遍历 ---> 二叉树序列化：将二叉树【打平】到一个字符串中
     * */
    /*String data = "1,2,3,#,4,#,#,#,#,";
    String SEP = ",";
    String NULL = "#";*/
    /*将二叉树序列化为字符串*/
    String serializeLevel(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        //初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (! q.isEmpty()) {
            TreeNode cur = q.poll();

            /*层级遍历代码位置*/
            if (cur == null) {
                 sb.append(NULL).append(SEP);
                 continue;
            }
            sb.append(cur.val).append(SEP);
            /********************/

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }




    /*
     * 4.2 利用层级遍历 ---> 字符串反序列化：用字符串构建二叉树
     * */
    /*String data = "1,2,3,#,4,#,#,#,#,";
    String[] nodes = data.split(",");*/
    /*将字符串反序列化为二叉树结构*/
    TreeNode deserializeLevel(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        //第一个元素就是root的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.length; ) {
            //队列中存的都是父节点
            TreeNode parent = q.poll();
            //父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (! left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }

            //父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (! right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }

        }
        return root;
    }


}
