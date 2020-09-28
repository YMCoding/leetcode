package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 对链表进行插入排序
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);

        ListNode pre = head;

        ListNode cur = head.next;

        dummy.next = head;

        while (cur != null) {
            // 本来就有序
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
            } else {

                ListNode p = dummy;

                // 找到一个位置使得p < cur < p.next
                while (p.next != cur && p.next.val < cur.val) {
                    p = p.next;
                }

                // 因为cur被插到前面，pre的指针需要跳过cur
                pre.next = cur.next;
                // 将cur插入到p和p.next之间

                cur.next = p.next;
                p.next = cur;

                // 完成插入后，cur回到pre后面
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}
