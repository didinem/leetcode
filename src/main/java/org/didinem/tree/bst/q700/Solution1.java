package org.didinem.tree.bst.q700;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL
 */
public class Solution1 {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode currentNode = root;

        if (currentNode == null) {
            return null;
        }

        int currentVal = currentNode.val;
        TreeNode nextNode = null;
        if (val == currentVal) {
            return currentNode;
        } else if (val < currentVal) {
            nextNode = currentNode.left;
        } else {
            nextNode = currentNode.right;
        }

        return searchBST(nextNode, val);
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.searchBST(null, 1));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
