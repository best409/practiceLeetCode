# 数据结构和算法必知必会的50个代码实现
## 数组
### 1.  Array.java
 * 1. 数组的插入、删除、按照下标随机访问操作

### 2.  GenericArray.java

 * 1. 简化模拟了ArrayList的源码实现



## 链表

### 1.  LinkedList 的标准实现代码

 * 1. 插入新节点 insert(LinkedList list, int data)
 * 2. 遍历链表   printList(LinkedList list)
 * 3. 通过节点值删除  deleteByKey(LinkedList list, int key)
 * 4. 通过节点索引删除 deleteAtPosition(LinkedList list, int index)

### 2.  LRUBasedArray.java

 * 1. 数组实现LRU缓存：T(n) = O(n) , S(n) = O(n), 不支持 null 缓存
 * 2. 用数组T[] 移动位置，用hashmp判断是否存在某个值和该值在数组中的下标位置