//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1142 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        if(null == l2) return l1;
        ListNode list = new ListNode(-1);
        ListNode predhead = list;

        while (l1 != null && l2!=null){
            if(l1.val <= l2.val){
                predhead.next = l1;
                l1 = l1.next;
            } else {
                predhead.next = l2;
                l2 = l2.next;
            }
            predhead = predhead.next;
        }
        predhead.next = l1==null? l2:l1;
        return list.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
