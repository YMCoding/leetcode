package info.ymcode.study.listnode.medium;

import info.ymcode.study.listnode.Node;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 二叉搜索树的中序遍历为 递增序列
 *
 *
 */
public class TreeToDoublyList {

    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        dfs(root);

        // 进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        pre.right = head;
        head.left = pre;

        return head;
    }

    private void dfs(Node cur) {

        if (cur == null) {
            return;
        }

        dfs(cur.left);

        // pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur, 当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if (pre == null) {
            head = cur;
        }else {
            // 反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=root的操作。
            // A 得右边是B
            pre.right = cur;
        }
        // B得左边是A
        cur.left = pre;
        // 移动链表指针
        pre = cur;

        dfs(cur.right);

    }

}
