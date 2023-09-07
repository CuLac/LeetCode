package Question_Interview.BinaryTreeBFS.Easy;

/*

637. Average of Levels in Binary Tree
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].



Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]

 */

import Question_Interview.BinaryTreeGeneral.TreeNode;

import java.util.*;

public class Q637_Average_of_Levels_in_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> ll = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>(); // in bfs we take queue to traverse one level completely

        if (root == null) {
            return ll;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();  // here n is the level size or number of elements in level
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll(); // removing/polling a node
                sum += node.val; // adding it to sum of the level
                if (node.left != null) { // now again we will add remove node left and right to queue for next level calculation
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ll.add(sum / n); // average value in the level
        }
        return ll;
    }
}
