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