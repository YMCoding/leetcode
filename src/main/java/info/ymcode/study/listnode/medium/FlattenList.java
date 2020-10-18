package info.ymcode.study.listnode.medium;

/**
 * 链表有个child得节点，指向其他链表，相当于有多层。展开链表
 */
public class FlattenList {


    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Node p = head;

        /**
         * 先把儿子，升级，碰到儿子的儿子，由于儿子已升级了。只需要把儿子的儿子再升级就行
         */
        while (p != null) {

            if (p.child != null) {

                Node next = p.next;

                Node child = p.child;

                p.next = child;

                p.child = null;

                child.prev = p;

                // 遍历孩子节点，走到最后
                while (child.next != null) {
                    child = child.next;
                }
                // 接上后一段链表
                child.next = next;
                // 双向指针
                if (next != null) {
                    next.prev = child;
                }
            }
            p = p.next;
        }
        return head;
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;
}
