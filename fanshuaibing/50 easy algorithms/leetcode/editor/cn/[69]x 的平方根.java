//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解法一：二分查找法
     * 时间复杂度：O(log(x))
     */
    public int mySqrt(int x) {

        if(x ==0){
            return 0;
        }
        //二分查找法，查找中位数的平方 小于等于x
        long left = 1;
        //任何数的平方根一定小于该数的一半。
        long right = x/2;
        long mid = 0;
        while(left < right){
            mid = (left + right) / 2 + 1;
            if (mid > x / mid)
                right = mid - 1;
            else
                left = mid ;
        }
        return (int)left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
