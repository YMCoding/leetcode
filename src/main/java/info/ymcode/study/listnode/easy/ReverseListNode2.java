package info.ymcode.study.listnode.easy;

import info.ymcode.study.listnode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReverseListNode2 {

    List<Integer> temp = new ArrayList();

    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        }

        doReverse(head);

        int[] result = new int[temp.size()];

        int index = 0;

        for (Integer integer : temp) {
            result[index++] = integer;
        }

        return result;
    }

    private void doReverse(ListNode head) {

        if (head == null) {
            return;
        }

        doReverse(head.next);

        temp.add(head.val);
    }
}
