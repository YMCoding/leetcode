package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRightList {

    /**
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 本质上就是找到倒数第k个节点，截断链表，倒数第k个截断指向头节点即可。
     * <p>
     * 需要处理边界，k大于链表长度的时候，会出现多次循环，对k需要进行处理
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int count = 0;

        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }


        if (k % count != 0) {
            // 计算出需要移动的次数
            k = k % count;
        } else {
            // k 是count的倍数，相当于不变
            return head;
        }


        // 快指针
        ListNode fast = head;
        // 慢指针
        ListNode slow = head;

        while (fast != null) {

            fast = fast.next;

            if (k < 0) {
                slow = slow.next;
            }

            k--;

        }

        if (slow == null || slow.next == null || k > 0) {
            return head;
        }

        ListNode splitNode = slow.next;

        // 截断链表
        slow.next = null;

        cur = splitNode;

        while (cur != null) {

            if (cur.next == null) {
                cur.next = head;
                break;
            }

            cur = cur.next;

        }

        return splitNode;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        l1.next = l2;

        RotateRightList rotateRightList = new RotateRightList();

        rotateRightList.rotateRight(l1, 2);

    }
}
