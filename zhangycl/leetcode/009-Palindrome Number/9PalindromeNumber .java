//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学

package leetcode.editor.cn;
//Java：回文数
public class P9PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {

        /*
         * 解法1：int 转成字符串，再判断；缺点占用额外空间
         * 因题目要求不能转成字符串，paas
         * */

        /*
         * 解法2：同题目7；将 int 数值反转，再判断是否是回文数，注意判断是否溢出
         * 时间复杂度：T(n) = O((logn)，空间复杂度：S(n) = O(1)
         * */
       /* if(x < 0) return false;
        int res = reverse(x);
        return res == x;*/


        /*
         * 解法3：同样是采用反转再比较，此次是只反转右半部分和左半部分比较。
         * 注意：数字的位数 log(n)/log 10 + 1 ；此外考虑数字位数的奇偶
         * 时间复杂度：T(n) = O((logn)，空间复杂度：S(n) = O(1)
         * */
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

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int val = x % 10;
            x /= 10;
            //判断是否有溢出
            if (res > Integer.MAX_VALUE /10 || res < Integer.MIN_VALUE /10) return 0;
            res = res * 10 + val;
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
