package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class ReverseListNode {

    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode newHead = null;

        ListNode cur = head;

        while (cur !=null){

            ListNode temp = cur.next;

            cur.next = newHead;

            newHead = cur;

            cur = temp;
        }

        return newHead;
    }
}
