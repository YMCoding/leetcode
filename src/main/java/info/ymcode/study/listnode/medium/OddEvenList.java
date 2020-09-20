package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;

        ListNode event = head.next;

        ListNode cur = odd;

        while (event != null && event.next != null) {
            odd.next = event.next;
            odd = odd.next;

            event.next = odd.next;
            event = event.next;
        }

        odd.next = cur;

        return head;
    }
}
