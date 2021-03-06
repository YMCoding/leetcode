package info.ymcode.study.tree.easy;

import info.ymcode.study.tree.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int nleft = maxDepth(root.left) ;

        int nright = maxDepth(root.right);

        return Math.max(nleft, nright) + 1;
    }
}
