package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 */
public class SplitListToParts {


    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }

        int n = 0;

        ListNode cur = root;

        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // 每段得长度
        int size = n / k;
        // 前mod个节点，每个节点多一个节点
        int mode = n % k;

        cur = root;

        ListNode[] result = new ListNode[k];

        for (int i = 0; cur != null && i < k; i++) {
            result[i] = cur;
            int currentSize = size;
            if (mode > 0) {
                currentSize++;
                mode--;
            }
            for (int j = 0; j < currentSize - 1; j++) {
                cur = cur.next;
            }
            // 尾节点置空
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return result;
    }
}
