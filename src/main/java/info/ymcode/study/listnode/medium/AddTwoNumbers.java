package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个链表求和
 */
public class AddTwoNumbers {
    /**
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //l1为null，直接不能进入上面while循环的情况下，直接返回l2
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //初始进位为0
        int pre = 0;
        //操作数
        ListNode mid = new ListNode(0);
        //返回头节点
        ListNode anws = mid;
        //当l1和l2都不为null时进入while循环
        while (l1 != null && l2 != null) {
            //操作数赋值
            mid.val = (l1.val + l2.val + pre) % 10;
            //更新进位
            pre = (l1.val + l2.val + pre) / 10;
            //更新头节点
            l1 = l1.next;
            l2 = l2.next;
            //头节点更新后判断是否为空
            if (l1 == null) {
                mid.next = pre == 0 ? l2 : addTwoNumbers(l2, new ListNode(pre));
                return anws;
            }
            //同上
            if (l2 == null) {
                mid.next = pre == 0 ? l1 : addTwoNumbers(l1, new ListNode(pre));
                return anws;
            }
            //l1 l2更新后都不为null，则设置操作数为0 进入下一次while循环
            mid.next = new ListNode(0);
            mid = mid.next;
        }

        return anws;

    }
}
