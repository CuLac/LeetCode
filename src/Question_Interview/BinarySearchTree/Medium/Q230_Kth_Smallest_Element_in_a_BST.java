package Question_Interview.BinarySearchTree.Medium;

/*

230. Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 */

import Question_Interview.BinarySearchTree.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Q230_Kth_Smallest_Element_in_a_BST {

    /*
        using binary search
        --> not best choice
        --> Time execute: best O(n), worst O(n^2)

     */
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /*
        Solution 2:
        DFS in-order recursive:

        --> time complexity: O(N)
     */

    // better keep these two variables in a wrapper class
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest_v2(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }

    /*
        Solution 3:
        DFS in-order iterative:

        --> time complexity: O(N) best
     */
    public int kthSmallest_v3(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }
}
