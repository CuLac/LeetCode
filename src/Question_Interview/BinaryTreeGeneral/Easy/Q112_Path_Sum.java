package Question_Interview.BinaryTreeGeneral.Easy;

/*

112. Path Sum
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 */

import Question_Interview.BinaryTreeGeneral.TreeNode;

public class Q112_Path_Sum {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        result = false;
        traverseBT(root, 0, targetSum);
        return result;

    }

    private void traverseBT(TreeNode node, int sum, int targetSum) {
        if (node == null) return;

        sum += node.val;

        if (node.left == null && node.right == null && sum == targetSum) {
            result = true;
            return;
        }
        traverseBT(node.left, sum, targetSum);
        traverseBT(node.right, sum, targetSum);
    }
}
