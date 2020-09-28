package info.ymcode.study.tree.medium;

import info.ymcode.study.listnode.ListNode;
import info.ymcode.study.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2叉树，每一层转成链表
 */
public class Tree2ListNode {

    /**
     * 输入：[1,2,3,4,5,null,7,8]
     * <p>
     * 1
     * /  \
     * 2    3
     * / \    \
     * 4   5    7
     * /
     * 8
     * <p>
     * 输出：[[1],[2,3],[4,5,7],[8]]
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {

        if (tree == null) {
            return new ListNode[]{};
        }

        LinkedList<TreeNode> queen = new LinkedList<TreeNode>();

        List<TreeNode> levelAllNodeList = new ArrayList<TreeNode>();

        queen.add(tree);

        int start = 0;

        int end = 1;

        List<ListNode> result = new ArrayList<ListNode>();

        while (!queen.isEmpty()) {


            TreeNode temp = queen.remove();

            levelAllNodeList.add(temp);

            start++;

            if (temp.left != null) {
                queen.add(temp.left);
            }

            if (temp.right != null) {
                queen.add(temp.right);
            }

            if (start == end) {

                start = 0;

                end = queen.size();

                ListNode dummy = new ListNode(0);

                ListNode pre = dummy;

                for (TreeNode treeNode : levelAllNodeList) {
                    pre.next = new ListNode(treeNode.val);
                    pre = pre.next;
                }

                result.add(dummy.next);

                levelAllNodeList = new ArrayList<TreeNode>();
            }
        }

        return result.toArray(new ListNode[]{});

    }
}
