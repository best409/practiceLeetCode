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
*  2、代码
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

### 3.  BinarySearchFramework.java

* 1、总结二分查找框架：
  1. 注意「搜索区间」和 while 的终止条件，如果存在漏掉的元素，记得在最后检查。
  2. 如果将「搜索区间」全都统一成两端都闭，好记，只要稍改nums[mid] == target条件处的代码和返回的逻辑即可，推荐拿小本本记下，作为二分搜索模板。
  3.  分析二分查找代码时，不要出现 else，全部展开成 else if 方便理解。
*  2、代码
```
/*
* 1、二分查找框架
*   1. 其中...标记的部分，就是可能出现细节问题的地方，需要关注。
*   2. 代码中left + (right - left) / 2就和(left + right) / 2的结果相同，但是有效防止了left和right太大直接相加导致溢出。
* */
int binarySearch(int[] nums, int target) {
    int left = 0, right = ...;

    while(...) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
        	...
        } else if (nums[mid] < target) {
        	left = ...
        } else if (nums[mid] > target) {
       	 right ...
        }
    }
    return ...;
}


/*
* 2、寻找一个数（基本的二分搜索）
*  1. 搜索区间的概念：while(left <= right)的终止条件是left == right + 1 ，写成区间的形式就是   			[right + 1, right]
*  2. 不足：不能查找 2 的 左边界和右边界，nums = [1,2,2,2,3]
* */

int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;//注意

    while (left <= right) {
        int mid = left + (right - left) / 2; //该写法可以防止溢出
        if (nums[mid] == target)
        	return mid;
        else if (nums[mid] < target)
        	left = mid + 1; //注意
        else if (nums[mid] > target)
        	right = mid - 1; //注意
    }

    return -1;
}

/*
* 3、寻找左边界的二分搜索
*      1. nums = [1,2,2,2,3]
* */
int left_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1; //注意
    //搜索区间为[left, right]
    while (left <= right) { //注意
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            //搜索区间变为[mid+1, right]
            left = mid + 1;
        } else if (nums[mid] > target) {
        	right = mid - 1; //注意
        } else if (nums[mid] == target) {
            //收缩右侧边界
            right = mid - 1;
        }

    }

    //检查出界情况：当while(left <= right)终止的条件是left =right + 1，由于 while 的退出条件
    是left == right + 1，所以当target比nums中所有元素都大时，会存在情况使得索引越界
    if (left >= nums.length || nums[left] != target)
    	return -1;
    	
    return left;
}


/*
* 4、寻找右侧边界的二分查找
*      1. nums = [1,2,2,2,3]
* */
int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right -left) / 2;
        if (nums[mid] < target) {
        	left = mid + 1;
        } else if (nums[mid] > target) {
        	right = mid - 1;
        } else if (nums[mid] == target) {
            //这里改成收缩左侧边界即可
            left = mid +1 ;
        }
    }

    //这里改为检查right 越界的情况
    if (right < 0 || nums[right] != target)
    	return -1;
    	
    return right;
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