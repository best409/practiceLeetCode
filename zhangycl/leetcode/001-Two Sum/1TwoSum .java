//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            /*
             * 解法1：暴力破解，两重循环进行遍历
             * 时间复杂度：T(n) = O(n^2)
             * 空间复杂度：S(n) = O(1)
             * */
           /* for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i,j};
                    }
                }
            }
            throw new IllegalArgumentException("not two sum  solution");*/


            /*
             * 解法2：使用hash table，空间换时间，一重循环进行遍历耗时O(n)，另一重使用 hash table 耗时O(1)
             * 时间复杂度：T(n) = O(n)
             * 空间复杂度：S(n) = O(n)
             * */
           /* Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length ; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int result = target - nums[i];
                if(map.containsKey(result) && map.get(result) != i) {
                    return new int[]{i,map.get(result)};
                }
            }
            throw new IllegalArgumentException("not two sum solution");*/

            /*
             * 解法3：使用hash table，空间换时间，同方法2，将两个for循环合并为一个
             * 时间复杂度：T(n) = O(n)
             * 空间复杂度：S(n) = O(n)
             * */
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}
