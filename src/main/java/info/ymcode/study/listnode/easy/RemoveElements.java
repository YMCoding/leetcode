package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(0);

        sentinel.next = head;

        ListNode pre = sentinel;

        ListNode cur = head;

        while (cur != null) {
            // 当前节点要被删除。则pre链表不要当前的节点
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                // 把当前节点加到pre节点
                pre = cur;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        RemoveElements removeElements = new RemoveElements();
        removeElements.removeElements(l1, 3);
    }
}
