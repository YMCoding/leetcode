package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * <p>
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 */
public class ReorderList {

    /**
     * 重排链表
     *
     * @param head
     */
    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode cur = head;

        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int mid = (count + 1) / 2;

        // head 0 1 2 3 4 5 6 7

        // 拆分链表      0 1 2 3 ，注意3后截断链表
        // 倒转后一段链表 7 6 5 4
        cur = head;

        ListNode curOneHead = head;

        ListNode twoHead = null;

        while (cur != null) {

            mid--;

            if (mid >= 0) {

                cur = cur.next;

                if (mid == 0) {
                    //截断链表
                    curOneHead.next = null;
                } else {
                    curOneHead = curOneHead.next;
                }
                continue;
            }

            // 反转剩下的链表
            ListNode temp = cur.next;

            cur.next = twoHead;

            twoHead = cur;

            cur = temp;
        }

        // 2.混合
        // oneHead 0  1  2  3
        // twoHead  7  6  5  4

        cur = head;

        while (cur != null && twoHead != null) {

            ListNode curNext = cur.next;

            ListNode twoNext = twoHead.next;

            cur.next = twoHead;

            twoHead.next = curNext;

            cur = curNext;

            twoHead = twoNext;

        }
    }

    public static void main(String[] args) {

        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        reorderList(l0);
    }
}
