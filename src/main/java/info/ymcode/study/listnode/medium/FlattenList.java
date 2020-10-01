package info.ymcode.study.listnode.medium;


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

                while (child.next != null) {
                    child = child.next;
                }
                child.next = next;

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
