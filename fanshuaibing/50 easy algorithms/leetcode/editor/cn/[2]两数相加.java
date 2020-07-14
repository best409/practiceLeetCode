//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4586 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(-1);
        ListNode head = list;

        boolean status = false; //进位标志
        int val = 0;
        while (l1 != null && l2 != null) {
            l1.val = status == false ? l1.val + l2.val : l1.val + l2.val + 1;
            if (l1.val >= 10) {
                l1.val = l1.val - 10;
                status = true;
            } else {
                status = false;
            }
            head.next = l1;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 != null) {
            if (status == false) {
                head.next = l2;
            } else {
               while (l2 != null) {
                   if (status) {
                       if(++l2.val >= 10){
                           l2.val = l2.val - 10;
                           status = true;
                       }else{
                           status = false;
                       }
                       head.next = l2;
                       head = head.next;
                       l2 = l2.next;
                   } else {
                       head.next = l2;
                       break;
                   }
               }
                if (l2 == null && status) {
                    head.next = constructNode();
                }
            }
        }else if (l2 == null && l1 != null) {
            if (status == false) {
                head.next = l1;
            } else {
              while (l1 != null) {
                  if (status) {
                      if(++l1.val >= 10){
                          l1.val = l1.val - 10;
                          status = true;
                      }else{
                          status = false;
                      }
                      head.next = l1;
                      head = head.next;
                      l1 = l1.next;
                  } else {
                      head.next = l1;
                      break;
                  }
              }
               //构建尾结点
                if (l1 == null && status) {
                    head.next = constructNode();
                }
            }
        }else if (l1 == null && l2 == null) {
            if (status == true) {
                head.next = constructNode();
            }
        }
        return list.next;
    }

    public ListNode constructNode() {
        ListNode node = new ListNode(1);
        node.next = null;
        return node;
    }

    public void getRoute(ListNode head,ListNode tmp,boolean status){
        while (tmp != null) {
            if (status) {
                if (++tmp.val >= 10) {
                    tmp.val = tmp.val - 10;
                    status = true;
                } else {
                    status = false;
                }
                head.next = tmp;
                head = head.next;
                tmp = tmp.next;
            } else {
                head.next = tmp;
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
