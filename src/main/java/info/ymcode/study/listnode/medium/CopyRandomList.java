package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.Node;

/**
 * 复杂链表的复制
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        // 1.在链表上实现复制
        // A -> B -> C   ==> A -> A' -> B -> B' -> C -> C'
        Node cur = head;

        while (cur != null) {

            Node copy = new Node(cur.val);

            copy.next = cur.next;

            cur.next = copy;

            cur = copy.next;
        }

        // 2.对节点'添加random节点
        cur = head;

        while (cur != null) {
            // random节点应该指向之前得random得复制节点，也就是random得下一节点
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        // 3.拆分链表

        Node newHead = head.next;

        Node pre = newHead;

        head.next = head.next.next;

        head = head.next;

        while (head != null) {

            pre.next = head.next;

            head.next = head.next.next;

            pre = pre.next;

            head = head.next;
        }

        return newHead;
    }
}
