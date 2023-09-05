package Question_Interview.BinarySearchTree.Easy;

/*

530. Minimum Absolute Difference in BST
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 */


import Question_Interview.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q530_Minimum_Absolute_Difference_in_BST {
    /*
        Solution 1:
        - Liệt kê tất cả các node trong cây vào 1 list theo phương pháp L-N-R
        - Tìm min bằng cách so sánh các phần tử trong list
     */

    private int diff;
    private int lastValue;

    public int getMinimumDifference(TreeNode root) {
        diff = Integer.MAX_VALUE;
        lastValue = Integer.MAX_VALUE;
        inorder(root);
        return diff;
    }

    private void inorder(TreeNode node){
        if(node != null){
            inorder(node.left);
            if(lastValue != Integer.MAX_VALUE){
                diff = Math.min(diff, node.val - lastValue);
            }

            lastValue = node.val;

            inorder(node.right);
        }
    }

    /*
        Solution 2: sử dụng stack
     */
    public int getMinimumDifference_v2(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int res = Integer.MAX_VALUE;
        TreeNode prev = null, curr = root;
        while(curr != null || ! stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != null) {
                res = Math.min(res, Math.abs(curr.val - prev.val));
            }
            prev = curr;
            curr = curr.right;
        }
        return res;
    }
}
