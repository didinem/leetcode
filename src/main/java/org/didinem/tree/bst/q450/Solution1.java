package org.didinem.tree.bst.q450;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // key == root.value
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left != null && root.right == null) {
            return root.left;
        } else if (root.left == null && root.right != null) {
            return root.right;
        }

        // root.left != null && root.right != null
        TreeNode returnNode = root;
        // 删除替换后的node，右子树的最小节点或者左子树的最大节点
        TreeNode replaceNode = root.right;
        for (;;) {
            if (replaceNode.left == null) {
                break;
            }
            replaceNode = replaceNode.left;
        }
        returnNode.val = replaceNode.val;
        returnNode.right = deleteNode(returnNode.right, returnNode.val);

        return returnNode;
    }

    public static void main(String[] args) {

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
