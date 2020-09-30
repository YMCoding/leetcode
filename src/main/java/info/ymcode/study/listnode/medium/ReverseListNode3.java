package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class ReverseListNode3 {


    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);

        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;

        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }

        step = 0;

        while (step < n - m) {

            // g- > p-> remove -> xxx
            ListNode remove = p.next;

            // g -> p -> remove -> p
            p.next = p.next.next;

            // 把remove节点，头插法，插入到g后面
            remove.next = g.next;
            g.next = remove;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        reverseBetween(l0, 2, 4);
    }

}
