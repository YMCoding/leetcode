package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样
 */
public class RandomListNode {

    private ListNode head;

    private Random random = new SecureRandom();

    public RandomListNode(ListNode head) {
        this.head = head;
    }

    /**
     * 蓄水池算法
     * <p>
     * 先用一个游标遍历, 计算节点的总数count
     * <p>
     * 从[0, count)随机一个整数
     */
    public int getRandom() {

        ListNode temp = head;

        int asn = temp.val;

        int i = 1;

        while (temp.next != null) {

            temp = temp.next;

            i++;

            if (random.nextInt(i) == 0) {
                asn = temp.val;
            }
        }

        return asn;
    }
}
