package Question_Interview.BinaryTreeGeneral.Easy;

/*

101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 */

public class Q101_Symmetric_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return check(left, right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        }
        if(p==null||q==null || p.val!=q.val) {
            return false;
        }
        return check(p.left,q.right) && check(p.right,q.left);
    }
}
