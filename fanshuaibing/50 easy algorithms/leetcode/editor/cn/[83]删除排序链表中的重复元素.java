//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tt = head;
        //判断当前节点和当前节点的下一个节点
        while (tt != null && tt.next != null) {
            //当前节点值和下一个节点的值比较
            if (tt.val == tt.next.val) {
                //将当前元素的指针只想下下个元素：：：：此时头节点的判断条件tt.next 只想发生变化
                tt.next = tt.next.next;
            } else {//tmpNode 节点值 == head 节点值
                //tmpNode 节点不动，head指针后移动
                tt = tt.next;
            }
        }
        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
