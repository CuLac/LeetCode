package Question_Interview.BinarySearchTree.Medium;

/*

98. Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 */

import Question_Interview.BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q98_Validate_Binary_Search_Tree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    // We use Integer instead of int as it supports a null value.
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (inorder(root.left) == false) {
            return false;
        }

        if (prev != null && root.val <= prev) return false;

        prev = root.val;
        return inorder(root.right);
    }
}
