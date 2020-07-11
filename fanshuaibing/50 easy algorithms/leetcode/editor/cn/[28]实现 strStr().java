//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int pos = 0;
        int needleIndex = 0;
        for (; needleIndex < needle.length() && pos < haystack.length(); ) {
            //needleIndex++ 放到了 haystack.length()后造成了死循环！！！！！：
            // 因为needleIndex = 0后，执行needleIndex++（循环条件）。
            // needle.charAt(1)！=haystack.charAt(pos)，执行needleIndex = 0，needleIndex++；
            if (needle.charAt(needleIndex) == haystack.charAt(pos)) {
                pos++;
                needleIndex++;
            } else {
                pos = pos - needleIndex + 1;
                needleIndex = 0;
            }
        }
        return needleIndex == needle.length() ? pos - needleIndex : -1;
    }

    /**
     * 解法二：滑动窗口
     */
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int needleLength = needle.length();
        int i = 0;
        for (; i < haystack.length() - needleLength + 1; i++) {
            if(haystack.substring(i,i+needleLength).equals(needle)){
                return i;
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
