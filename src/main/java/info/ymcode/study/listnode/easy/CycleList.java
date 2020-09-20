package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 环形链表 - 双指针
 */
public class CycleList {
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;

        ListNode quic = head.next;

        while (slow != quic){
            if(quic == null || quic.next == null){
                return false;
            }

            slow = slow.next;
            quic = quic.next.next;
        }

        return true;
    }

}
