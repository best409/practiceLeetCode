# LeetCode 解法总结
## 常用的时间复杂度
O(1) < O(logn) < (n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)



## 简单

### 1.  两数之和（题号：1）
  * 解法1：暴力破解，两重循环进行遍历
      * 时间复杂度：T(n) = O(n^2)，空间复杂度：S(n) = O(1)
  * 解法2：使用hash table，空间换时间，一重循环进行遍历耗时O(n)，另一重使用 hash table 耗时O(1)
    * 时间复杂度：T(n) = O(n)， 空间复杂度：S(n) = O(n)
  * 解法3【推荐】：使用hash table，空间换时间，同方法2，将两个for循环合并为一个
      * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(n)
  * 代码
```
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length ; i++) {
        int result = target - nums[i];
        if(map.containsKey(result) && map.get(result) != i) {
            return new int[]{i,map.get(result)};
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("not two sum solution");
}
```
### 2.  三数之和（题号：15）
  * 解法1：
  * 解法2：
  * 解法3：
  * 代码
```

```


## 中等

### 1.  两数相加（题号：2）
* 解法：模拟两数相加，每次相加都会产生进位 carry,
    * carry max 1,because max 9+9+1 = 19
    * 使用头结点，carry 取模，新节点 取余
    * 注意最后判断 carry 是否为1, 为1 则末尾增加值为 1 的节点
* 时间复杂度：T(n) = O(max(m, n))，空间复杂度：S(n) = O(max(m, n) + 1)

* 代码
```
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    
    if (carry > 0) {
    	curr.next = new ListNode(carry);
    } 
    return dummyHead.next;
}
```
