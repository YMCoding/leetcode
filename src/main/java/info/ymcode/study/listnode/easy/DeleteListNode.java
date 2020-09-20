package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
public class DeleteListNode {
    public ListNode deleteNode(ListNode head, int val) {

        if(head == null){
            return null;
        }

        ListNode cur = head;

        if(cur.val == val){
            return cur.next;
        }

        while (cur != null){

            if(cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
