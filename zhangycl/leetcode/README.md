# LeetCode 解法总结
## 常用的时间复杂度
O(1) < O(logn) < (n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)



## 简单

### 1.  两数之和（题号：1）
  * 标签：数组、哈希表
  * 解法1：
        * 暴力破解，两重循环进行遍历
      * 时间复杂度：T(n) = O(n^2)，空间复杂度：S(n) = O(1)
  * 解法2：
      * 使用hash table，空间换时间，一重循环进行遍历耗时O(n)，另一重使用 hash table 耗时O(1)
    * 时间复杂度：T(n) = O(n)， 空间复杂度：S(n) = O(n)
  * 解法3【推荐】：
        * 使用hash table，空间换时间，同方法2，将两个for循环合并为一个
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
### 2.  整数反转（题号：7）
  * 标签：数学
  * 解法1：
	  * 使用 int 类型，比较过程中注意溢出(Integer.MAX_VALUE、Integer.MIN_VALUE) 需要除 10
	* 时间复杂度：T(n) = O(logn)，空间复杂度：S(n) = O(1)
  * 解法2：
	  * 使用 long 类型，最后比较是否溢出(Integer.MAX_VALUE、Integer.MIN_VALUE)
	* 时间复杂度：T(n) = O((logn)，空间复杂度：S(n) = O(1)
  * 代码
```
public int reverse(int x) {
    long res = 0;
    while (x !=0) {
        int val = x % 10;
        x /= 10;
        res = res * 10 + val;
    }
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
    return (int)res;
}
```
### 3.  回文数（题号：9）
  * 标签：数学
  * 解法1：
	* int 转成字符串，再判断，缺点占用额外空间，因题目要求不能转成字符串，paas
  * 解法2：
	  * 同题目7；将 int 数值反转，再判断是否是回文数，注意判断是否溢出
	* 时间复杂度：T(n) = O((logn)，空间复杂度：S(n) = O(1)
   * 解法3：
	  * 同样是采用反转再比较，此次是只反转右半部分和左半部分比较。
	  * 注意：数字的位数 log(n)/log 10 + 1 ；此外考虑数字位数的奇偶
	* 时间复杂度：T(n) = O((logn)，空间复杂度：S(n) = O(1)
   * 代码
```
public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int digit = (int) (Math.log(x) / Math.log(10) +1); //总位数
    //后半部分倒转后的结果
    int revert = 0;
    int val = 0;
    for (int i = 0; i < digit / 2; i++) {
        val = x % 10;
        x /= 10;
        revert = revert * 10 + val;
    }

    //位数为偶数
    if (digit % 2 == 0 && revert == x)  return  true;
    //位数为偶数
    if (digit % 2 != 0 && revert == x / 10)  return  true;
    return  false;
}
```


## 中等

### 1.  两数相加（题号：2）
* 标签：链表、数学
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
### 2.  无重复字符的最长子串（题号：3）
* 标签：哈希表、双指针、字符串、Sliding Window
* 解法1：
	* 暴力破解，两重循环穷举所有子串O(n^2)，一次遍历使用 hash 判断子串是否重复O(n)
	* 时间复杂度：T(n) = O(n^3)，空间复杂度：S(n) = O(min(m,n)), m和n分别表示子串和父串长度
* 解法2：
	* 双指针+滑动窗口+备忘录，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 HashSet 判断滑动窗口是否重复O(1)
	* 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(min(m,n)),  m和n分别表示子串和父串长度，hash保存子串
* 解法3【推荐】：
	* 双指针+滑动窗口+备忘录+剪枝，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 HashMap 判断滑动窗口是否重复O(1), 因为 HashMap 可以存储下标跳跃剪枝
	* 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(min(m,n)),  m和n分别表示子串和父串长度，hash保存子串
* 解法4：
	* 双指针+滑动窗口+备忘录+剪枝，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 数组(使用于字符集较小的情况) 判断滑动窗口是否重复O(1), 数组[字符值]=下标 用数组存储下标跳跃剪枝
	* 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(n), n表示字符集长度
*  代码
```
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0; j < n; j++) {
        if (map.containsKey(s.charAt(j))) {
        	i = Math.max(map.get(s.charAt(j)), i);
        }

        ans  = Math.max(ans, j - i + 1);
        map.put(s.charAt(j), j+1); //下标 + 1 代表 i 要移动的下个位置
    }
    return ans;
}
```