package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class SplitListNodeByX {

    public ListNode partition(ListNode head, int x) {

        if (head == null || (head.next == null && head.val == x)) {
            return head;
        }

        ListNode less = new ListNode(0);

        ListNode lessPre = less;

        ListNode more = new ListNode(0);

        ListNode morePre = more;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                lessPre.next = new ListNode(cur.val);
                lessPre = lessPre.next;
            } else {
                morePre.next = new ListNode(cur.val);
                morePre = morePre.next;
            }
            cur = cur.next;
        }

        lessPre.next = more.next;

        return less.next;
    }
}
