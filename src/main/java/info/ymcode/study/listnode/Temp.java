package info.ymcode.study.listnode;

public class Temp {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        while (listNode1 != null) {
            ListNode node = next(listNode1);
            System.out.println(String.valueOf(node));
            node = node.next;
        }
    }

    private static ListNode next(ListNode node) {
        System.out.println(String.valueOf(node));
        return node;
    }
}
