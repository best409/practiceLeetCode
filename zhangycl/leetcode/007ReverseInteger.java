//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

package leetcode.editor.cn;
//Java：整数反转
public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {

        /*
         * 解法1：使用 int 类型，比较过程中注意溢出(Integer.MAX_VALUE、Integer.MIN_VALUE) 需要除 10
         * 时间复杂度：T(n) = O(log(x))，空间复杂度：S(n) = O(1)
         * */
        int res = 0;
        while (x !=0) {
            int val = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) return 0;
            res = res * 10 + val;
        }

        return res;

        /*
         * 解法2：使用 long 类型，最后比较是否溢出(Integer.MAX_VALUE、Integer.MIN_VALUE)
         * 时间复杂度：T(n) = O(log(x))，空间复杂度：S(n) = O(1)
         * */

       /* long res = 0;
        while (x !=0) {
            int val = x % 10;
            x /= 10;
            res = res * 10 + val;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;*/

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
