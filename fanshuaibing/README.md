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
        
    
    