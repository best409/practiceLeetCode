# 数据结构和算法必知必会的50个代码实现
## 刷题框架总结
### 1.  Framework.java
* 1、数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储），各种数据结构的遍历 + 访问无非两种形式：线性和非线性。

	1. 线性就是 for/while 迭代为代表
	2. 非线性就是 递归 为代表。
* 2、数据结构是工具，算法是通过合适的工具解决特定问题的方法。

	1. 先刷二叉树，二叉树最容易培养框架思维，大部分算法技巧，本质上都是树的遍历问题。
	2. 只要涉及递归问题，都是树的问题。
* 3、总结

	1. 数据结构的基本存储方式就是链表和顺序两种，基本操作就是增删改查，遍历方式无非迭代和递归。
	2. 刷算法题建议从【树】分类开始刷，结合框架思维，通过刷二叉树专题把树结构理解到位，然后再去看回溯、动归、分治等算法专题。
*  4、代码
```
/* 1、数组遍历框架，典型的线性迭代结构*/
void traverse(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
    //迭代访问 arr[i]
    }
}


/*2、链表遍历框架，兼具迭代和递归结构*/
//基本的单链表节点
class ListNode {
    int val;
    ListNode next;
}

//迭代访问
void traverse(ListNode head) {
    for (ListNode p = head; p != null; p = p.next) {
    	//迭代访问 p.val
    }
}

//递归访问
void traverse1(ListNode head) {
    //递归访问 head.val
    traverse1(head.next);
}


/* 3、二叉树遍历框架，典型的非线性递归遍历结构 */
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

/*4、二叉树框架扩展为 N 叉树的遍历框架*/
//基本的 N 叉树节点
class NTreeNode {
    int val;
    NTreeNode[] children;
}

void traverse(NTreeNode root) {
    for (NTreeNode child : root.children) {
    	traverse(child);
    }
}

```

### 2.  BinaryTreeFramework.java

* 1、总结二叉树的前、中、后学遍历、层级遍历的框架，以序列化和反序列化为例：
  1. 实现序列化：前中后序遍历
  2. 实现反序列化：前（root在开头）、后（root在结尾）、层级遍历（root在开头）、（中序无法实现反序列化，因为无法确定root的位置）
*  4、代码
```
/*基本的二叉树节点*/
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int value) {
   		this.val = value;
    }
}



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
    }//while
}
```



## 数组

### 1.  Array.java
 * 1. 数组的插入、删除、按照下标随机访问操作

### 2.  GenericArray.java

 * 1. 简化模拟了ArrayList的源码实现
 * 

## 链表

### 1.  LinkedList 的标准实现代码

 * 1. 插入新节点 insert(LinkedList list, int data)
 * 2. 遍历链表   printList(LinkedList list)
 * 3. 通过节点值删除  deleteByKey(LinkedList list, int key)
 * 4. 通过节点索引删除 deleteAtPosition(LinkedList list, int index)

### 2.  LRUBasedArray.java

 * 1. 数组实现LRU缓存：T(n) = O(n) , S(n) = O(n), 不支持 null 缓存
 * 2. 用数组T[] 移动位置，用hashmp判断是否存在某个值和该值在数组中的下标位置