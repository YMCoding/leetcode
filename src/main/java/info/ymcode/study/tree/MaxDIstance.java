package info.ymcode.study.tree;

import java.util.Map;

/**
 *如果我们把二叉树看做图，父子节点之间的连线看成是双向的，我们姑且定义“距离”为两个节点之间边的个数。
 *
 * 写一个程序求一棵二叉树中相距最远的两个节点之间的距离
 */
public class MaxDIstance {

    int maxLen = 0;

    /**
     * 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
     *
     *      只需要知道左右子树的深度，然后加起来即可。
     *
     * 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者
     *
     *      需要知道左子树的最远距离，右子树的最远距离。
     * @param parent
     */
    public void getMaxDistance(BinTree parent) {

        if (parent == null) {
            return;
        }

        if (parent.left == null) {
            parent.nMaxLeft = 0;
        }

        if (parent.right == null) {
            parent.nMaxRight = 0;
        }

        //如果左子树不为空，递归寻找左子树最长距离
        if (parent.left != null) {
            getMaxDistance(parent.left);
        }

        // 如果右子树不为空，递归寻找右子树最长距离
        if (parent.right != null) {
            getMaxDistance(parent.right);
        }

        if (parent.left != null) {
            parent.nMaxLeft = Math.max(parent.left.nMaxLeft, parent.left.nMaxRight) + 1;
        }

        if (parent.right != null) {
            parent.nMaxRight = Math.max(parent.right.nMaxLeft, parent.right.nMaxRight) + 1;
        }

        maxLen = Math.max(parent.nMaxLeft + parent.nMaxRight, maxLen);
    }
}
