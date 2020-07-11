//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1146 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(null == strs){
            throw new IllegalArgumentException();
        }
        if(strs.length <1){
            return "";
        }
        String commonStr = strs[0];//选取第一个字符串为公共前缀
        for (int i = 1; i < strs.length && commonStr.length()!=0; i++) {
            int eleIndex = 0;
            int j = 0;
            for (; j < commonStr.length() && eleIndex < strs[i].length(); j++) {
                if(commonStr.charAt(j) == strs[i].charAt(eleIndex)){
                    eleIndex++;
                    continue;
                }else{
                    commonStr = commonStr.substring(0,j);
                    break;
                }
            }
            if(eleIndex == strs[i].length() || commonStr.length() == j){
                commonStr = commonStr.substring(0,j);
            }

        }
        return commonStr.length() == 0 ? "" : commonStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
