package Question_Interview.BinaryTreeGeneral.Medium;

/*

105. Construct Binary Tree from Preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
is the inorder traversal of the same tree, construct and return the binary tree.

 */

import Question_Interview.BinaryTreeGeneral.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    //Solution 1

    // Recursive function to perform inorder traversal on a given binary tree
    public static void inorderTraversal(TreeNode root)
    {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // Recursive function to perform postorder traversal on a given binary tree
    public static void preorderTraversal(TreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Recursive function to construct a binary tree from a given
    // inorder and preorder sequence
    public static TreeNode construct(int start, int end,
                                 int[] preorder, AtomicInteger pIndex,
                                 Map<Integer, Integer> map) {
        // base case
        if (start > end) {
            return null;
        }

        // The next element in `preorder[]` will be the root node of subtree
        // formed by sequence represented by `inorder[start, end]`
        TreeNode root = new TreeNode(preorder[pIndex.getAndIncrement()]);

        // get the root node index in sequence `inorder[]` to determine the
        // left and right subtree boundary
        int index = map.get(root.val);

        // recursively construct the left subtree
        root.left = construct(start, index - 1, preorder, pIndex, map);

        // recursively construct the right subtree
        root.right = construct(index + 1, end, preorder, pIndex, map);

        // return current node
        return root;
    }

    // Construct a binary tree from inorder and preorder traversals.
    // This function assumes that the input is valid, i.e., given
    // inorder and preorder sequence forms a binary tree.
    public static TreeNode construct(int[] inorder, int[] preorder)
    {
        // create a map to efficiently find the index of any element in
        // a given inorder sequence
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // `pIndex` stores the index of the next unprocessed node in a preorder
        // sequence. We start with the root node (present at 0th index).
        AtomicInteger pIndex = new AtomicInteger(0);

        return construct(0, inorder.length - 1, preorder, pIndex, map);
    }


    //Solution 2
    private int i = 0;
    private int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
}
