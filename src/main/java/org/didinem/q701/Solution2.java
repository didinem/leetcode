package org.didinem.q701;

public class Solution2 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }


        return root;
    }

    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();

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
