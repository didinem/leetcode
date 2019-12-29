package org.didinem.q701;

public class Solution1 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode currentNode = root;
        for (;;) {
            TreeNode nextNode = null;
            if (val == currentNode.val) {
                break;
            } else if (val < currentNode.val) {
                nextNode = currentNode.left;
                if (nextNode == null) {
                    currentNode.left = new TreeNode(val);
                    break;
                }
            } else{
                nextNode = currentNode.right;
                if (nextNode == null) {
                    currentNode.right = new TreeNode(val);
                    break;
                }
            }
            currentNode = nextNode;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode root = solution1.insertIntoBST(null, 4);
        solution1.insertIntoBST(root, 2);
        solution1.insertIntoBST(root, 7);
        solution1.insertIntoBST(root, 1);
        solution1.insertIntoBST(root, 3);
        System.out.println(root);

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
