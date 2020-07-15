//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        /*
         * 解法1：暴力破解，两重循环穷举所有子串O(n^2)，一次遍历使用 hash 判断子串是否重复O(n)
         * 时间复杂度：T(n) = O(n^3)，空间复杂度：S(n) = O(min(m,n)), m和n分别表示子串和父串长度
         * */
        /*int n = s.length();
        //保存当前满足条件的最大值
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n ; j++) { //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i); //更新 ans
            }
        }
        return ans;*/






        /*
         * 解法2：双指针+滑动窗口+备忘录，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 HashSet 判断滑动窗口是否重复O(1)
         * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(min(m,n)), m和n分别表示子串和父串长度，hash保存子串
         * */

        /*int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < n && j < n) {
            if (! set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans  = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;*/



        /*
         * 解法3：双指针+滑动窗口+备忘录+剪枝，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 HashMap 判断滑动窗口是否重复O(1), 因为 HashMap 可以存储下标跳跃剪枝
         * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(min(m,n)), m和n分别表示子串和父串长度，hash保存子串
         * */

        /*int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            ans  = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1); //下标 + 1 代表 i 要移动的下个位置
        }
        return ans;*/


        /*
         * 解法4：双指针+滑动窗口+备忘录+剪枝，一重循环遍历字符串O(n)，用两个指针维护一个滑动窗口，用 数组(使用于字符集较小的情况) 判断滑动窗口是否重复O(1), 数组[字符值]=下标 用数组存储下标跳跃剪枝
         * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O(n), n表示字符集长度
         * */
        int n = s.length();
        int ans = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1; //（下标 + 1） 代表 i 要移动的下个位置
        }
        return ans;

    }

        /*
         * 判断字符串s，从下标start到end,左闭右开 是否存在重复的
         * */
        public boolean allUnique(String s, int start, int end) {
            Set<Character> set = new HashSet<>();//初始话 hash set
            for (int i = start; i < end; i++) { //遍历每个字符
                Character ch = s.charAt(i);
                if (set.contains(ch)) return false; //判断字符在不在 set 中
                set.add(ch); //不在的话将该字符添加到 set 里边
            }
            return true;

        }


}




//leetcode submit region end(Prohibit modification and deletion)

}
