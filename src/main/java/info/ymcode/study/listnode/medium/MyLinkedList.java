package info.ymcode.study.listnode.medium;

import org.omg.PortableInterceptor.INACTIVE;

public class MyLinkedList {

    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {

        if (index == 0) {
            return head == null ? -1 : head.val;
        }

        Node cur = head;

        while (index >= 0 && cur != null) {
            cur = cur.next;
            index--;
        }

        return index > 0 ? -1 : cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node inserNode = new Node(val);

        Node cur = head;

        while (cur != null) {
            if (cur.next == null) {
                cur.next = inserNode;
                return;
            }
            cur = cur.next;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // 添加到头
        if (index < 0) {
            addAtHead(val);
            return;
        }

        Node cur = head;

        while (index > 0 && cur != null) {

            if (index == 1) {
                Node temp = cur.next;

                cur.next = new Node(val);

                cur.next.next = temp;
                return;
            }
            cur = cur.next;
            index--;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index == 0) {
            head = head.next;
        }

        Node cur = head;

        while (index >= 0 && cur != null) {
            index--;
            // 要删除得节点得前节点
            if (index == 0 && cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

    }

    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        obj.get(1);
        obj.deleteAtIndex(1);
        obj.get(1);
    }
}
