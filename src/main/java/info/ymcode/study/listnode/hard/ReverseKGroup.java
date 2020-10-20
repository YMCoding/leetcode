package info.ymcode.study.listnode.hard;

import info.ymcode.study.listnode.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 */
public class ReverseKGroup {

    /**
     * 给你这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1 || head == null || head.next == null) {
            return head;
        }

        return helper(head, k-1);
    }

    public ListNode helper(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode start = head;

        ListNode end = start;

        int index;

        // 找到需要反转的临界点
        for (index = 0; index < k; index++) {
            if (end == null) {
                break;
            }
            end = end.next;
        }

        // 不够k个，不需要反转
        if (index != k || end == null) {
            return head;
        }

        ListNode node = end == null ? null : end.next;

        // 截断
        end.next = null;

        //翻转这k个节点
        reverse(start);

        // 让前k个节点的头节点的next指向后k个节点的尾节点
        start.next = helper(node, k);

        return end;
    }

    /**
     * 反转
     * @param head
     */
    public void reverse(ListNode head){

        ListNode pre=head,next=pre.next;

        while (next!=null){

            ListNode tmp=next.next;

            next.next=pre;

            pre=next;

            next=tmp;
        }
    }
}
