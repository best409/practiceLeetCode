//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;

//Java：N叉树的前序遍历
public class P589NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {

        /*
         * 解法1：使用框架遍历
         * */
        List<Integer> result = new ArrayList<>();
        //自顶向下的编程方法
        helper(root, result);
        return result;


    }

    public void helper(Node root, List<Integer> result) {
        if (root == null) return;
         result.add(root.val);
        if(root.children != null) {
            for (Node child : root.children) {

                helper(child, result);
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
