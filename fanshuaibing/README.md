LeetCode 习题记录

###简单:
    1:两数之和           
      （1）暴力法：两遍循环 时间复杂度：O（n方）；空间复度O（1）
      （2）哈希表：一遍循环 时间复杂度：O（n）;空间复杂度O（n）
           以数组的值作为hashmap的key,索引下标志作为hashmap的值。每次遍历数组中的值时，
           查找其值对应的余数target-nus[i]是否在hashmap中,如果在说明查找到且返回值为：
           {i,map.get(target - nums[i])}.否则将该值存放到hashmap中map.put(nums[i],i)
                eg:[2,7,6],target = 9;
                   step 1： hashmap中查找是否包含key = target- 2 =7,否：hashmap 中存放（2，0）；
                   step 2： hashmap中查找是否包含key = target- 7 =2，是：返回{map.get(2),i}
    
    7:整数反转 - 卡在了溢出判断！
        牛人解法：long 类型来接收反转后的值，然后强制转换为int类型。如果强转后的值与原来的long类型值相等，
        那么反转值没有溢出。
           eg: long res = 100;
               强制类型转换 int res' = (int)res ;
               res == res' : 反转值没有溢出
               
    9:回文数字 - 借鉴题7：整数反转应用
    
    13:罗马数字转整数：意在审题，注意给出的规则:左边的数小于右侧的数，左边的数符号为'-'，反之为'+'
        时间复杂度：O(n)
        空间复杂度：O(1）;
        
    28:实现strStr() : 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
           解法一：暴力解法：以needle为参照对象，逐个和haystack比对。
           解法二：滑动窗口 : 用到了字符串substring函数，优点像作弊。
                eg: haystack = abcdefg ; needle = cde;执行过程如下：
                    step 1：  abcdefg
                              cde
                    step 2：  abcdefg
                               cde
                    step 2：  abcdefg
                                cde
           //Todo
           解法三：KMP（看毛片算法）：动作太复杂没学会！
    14:最长公共前缀----解题思路同 28，先以首个字符串为公共前缀：str，然后与其余字符串逐个比较，查找公共前缀即可
       //Todo
       思维拓展：查找字符串的前缀和后缀最大公共长度（KMP）
       
    20:有效的括号 ：利用栈的特性
        时间复杂度：O（n）
        空间复杂读：O（n）
    
    21:删除排序数组中重复出现的元素：双指针方法，遍历一次
        时间复杂度：O(N+n); N:数组的长度，n：重复的次数
        空间复杂度：O(1）
    
    27:移除元素：遍历丢弃指定元素，给原始数组重新赋值
       时间复杂度：O(N+n)；N:数组的长度，n：重复的次数
       空间复杂度：O(1）
    35:搜索插入位置：二分查找法的应用
    