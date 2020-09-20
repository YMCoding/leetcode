package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 输入：1->2->4, 1->3->4
 * <p>
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode newHead = null;

        ListNode cur = newHead;

        while (l1 != null && l2 != null) {

            boolean temp = l1.val < l2.val;

            if (cur == null) {

                cur = temp ? l1 : l2;

                if (temp) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }

                newHead = cur;

                continue;
            }

            cur.next = temp ? l1 :l2;

            if (temp) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return newHead;
    }
}
