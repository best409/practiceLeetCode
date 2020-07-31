//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            /*
             * 解法1：中序遍历：左-根-右
             * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = 最坏O(n)，平均情况为O(h)，h=logn，压栈消耗，h 是二叉树的高度。
             * */
           /* List<Integer> result = new ArrayList<>();
            //自顶向下的编程方法
            helper(root, result);
            return result;*/

            /*
             * 解法2：基于栈遍历：利用栈，去模拟递归。
             * 递归压栈的过程，就是保存现场，就是保存当前的变量，而解法一中当前有用的变量就是 node，所以我们用栈把每次的 node 保存起来即可。
             * 时间复杂度：T(n) = O(n)，空间复杂度：S(n) = O（h），压栈消耗，h 是二叉树的高度。
             * */
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;

        }

        public void helper(TreeNode root, List<Integer> res) {
            //中序遍历：左-根-右
            if (root != null) {
                if (root.left != null)
                    helper(root.left, res);

                res.add(root.val);

                if (root.right != null)
                    helper(root.right, res);
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
