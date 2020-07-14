//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1674 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(null == s){
            return false;
        }
        if("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(stack.empty() == false && stack.peek() == getSymReverse(tmp)){
                stack.pop();
            }else{
                stack.add(tmp);
            }
        }
        return stack.empty() ? true : false;
    }
    //'('，')'，'{'，'}'，'['，']'
    public Character getSymReverse(Character c){
        switch (c) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
