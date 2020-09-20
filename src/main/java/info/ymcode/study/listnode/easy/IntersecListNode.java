package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 两个链表相交
 */
public class IntersecListNode {
    /**
     * pA走过的路径为A链+B链
     *
     * pB走过的路径为B链+A链
     *
     * pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐，如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。
     *
     * pA:1->2->3->4->5->6->null->9->5->6->null
     *
     * pB:9->5->6->null->1->2->3->4->5->6->null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }

}
