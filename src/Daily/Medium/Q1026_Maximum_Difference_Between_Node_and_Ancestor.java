package Daily.Medium;

/*
1026. Maximum Difference Between Node and Ancestor
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.



Example 1:

Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.


Example 2:

Input: root = [1,null,2,null,0,3]
Output: 3

 */

import Daily.TreeNode;

public class Q1026_Maximum_Difference_Between_Node_and_Ancestor {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}
