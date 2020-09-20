package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 链表是否是回文
 */
public class PalindromeListNode {
    /**
     * 链表是否是回文
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 1.找到链表的中间节点，同时逆转链表前半部分
        ListNode cur1 = head;
        ListNode cur2 = head;
        ListNode pre = null;
        // 1 - 2 - 2 - 1
        while (cur2 != null && cur2.next != null) {

            cur2 = cur2.next.next;

            ListNode temp = cur1.next;

            cur1.next = pre;

            pre = cur1;

            cur1 = temp;
        }
        // 1 <- 2 <- pre  cur1 -> 2 ->1
        // 链表为奇数，
        if (cur2 != null) {
            cur1 = cur1.next;
        }

        // 遍历cur 和pre
        while (cur1 != null && pre != null) {
            if (cur1.val != pre.val) {
                return false;
            }
            cur1 = cur1.next;
            pre = pre.next;
        }

        return true;
    }
}
