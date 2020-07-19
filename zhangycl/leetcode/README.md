# LeetCode 解法总结（要求：执行效率超90%）
## 常用的时间复杂度
O(1) < O(logn) < (n) < O(nlogn) < O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)



## 简单

### 1.  两数之和（题号：1）
  * 标签：数组、哈希表
  * 解法1：
        * 暴力破解，两重循环进行遍历
      * 时间复杂度：T(n) = O(n^2)，空间复杂度：S(n) = O(1)
  * 解法2：
      * 两边哈希表，使用hash table，空间换时间，一重循环进行遍历耗时O(n)，另一重使用 hash table 耗时O(1)
    * 时间复杂度：T(n) = O(n)， 空间复杂度：S(n) = O(n)
  * 解法3【推荐】：
        * 一遍哈希表，使用hash table，空间换时间，同方法2，将两个for循环合并为一个
      * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(n)
  * 代码
```
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length ; i++) {
        int result = target - nums[i];
        if(map.containsKey(result) && map.get(result) != i) {
        	//注意i和map.get(result) 的先后位置
            return new int[]{map.get(result), i};
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
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    
    int revertedNumber = 0;
    //判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
    while (x > revertedNumber) {    	
        revertedNumber = revertedNumber * 10 + x % 10;
        x /= 10;
    }
    
    //判断奇偶数情况
    return x == revertedNumber || x == revertedNumber / 10;
}
```
### 4.  罗马数字转整数（题号：13）
  * 标签：数学、字符串
  * 解法1：
	* 暴力求解，遍历字符串
	* 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(1)
  * 解法2：
	* 利用题目中的规则，若数字大的字母在前，而数字小的字母在后则做加法，反之则做减法。
	* 注意事项：用switch匹配比用HashMap匹配快很多
	* 时间复杂度：T(n) = O((n)，空间复杂度：S(n) = O(1) 
   * 代码
```
public int romanToInt(String s) {
    int sum = 0;
    int preNum = getValue(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
        int num = getValue(s.charAt(i));
        if (preNum >= num) {
        	sum += preNum;
        } else {
            //前面的数值小于后边的，做减法
            sum -= preNum;
        }
        preNum = num;
    }
    //此时preNum表示的是最后一个数字的值
    sum += preNum;
    return sum;
}

/*
* 根据罗马数字得到对应的数值
* */
private int getValue(char ch) {
    switch (ch) {
        case 'I' : return 1;
        case 'V' : return 5;
        case 'X' : return 10;
        case 'L' : return 50;
        case 'C' : return 100;
        case 'D' : return 500;
        case 'M' : return 1000;
        default: return 0;
    }
}
```

## 中等

### 1.  两数相加（题号：2）（未超过90%）
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
### 2.  无重复字符的最长子串（题号：3）未超90%
* 标签：哈希表、双指针、字符串、Sliding Window
* 解法1：
	* 暴力破解，两重循环穷举所有子串O(n^2)，一次遍历使用 hash 判断子串是否重复O(n)
	* 时间复杂度：T(n) = O(n^3)，空间复杂度：S(n) = O(min(m,n)), m和n分别表示子串和父串长度
* 解法2：
	* 双指针+滑动窗口+备忘录，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 HashSet 判断滑动窗口是否重复O(1)
	* 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(min(m,n)),  m和n分别表示子串和父串长度，hash保存子串
* 解法3【推荐】：（未超过90%）
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