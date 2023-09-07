package Question_Interview.BinaryTreeBFS.Medium;

/*

199. Binary Tree Right Side View
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]


Example 2:

Input: root = [1,null,3]
Output: [1,3]


Example 3:

Input: root = []
Output: []

 */

import Question_Interview.BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        helper(root, list, 0);
        return list;
    }

    private void helper(TreeNode curr, List<Integer> list, int currentDepth) {
        if (curr == null) {
            return;
        }

        //do mỗi 1 tầng chúng ta chỉ lấy 1 giá trị duy nhất bên phải
        if (currentDepth == list.size()) {
            list.add(curr.val);
        }

        helper(curr.right, list, currentDepth + 1);
        helper(curr.left, list, currentDepth + 1);
    }


    public List<Integer> rightSideView_v2(TreeNode root) {
        if (root == null)
            return new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> res = new ArrayList();

        while(!queue.isEmpty()){
            int size = queue.size();

            while (size -- > 0){
                TreeNode cur = queue.poll();
                if (size == 0)
                    res.add(cur.val);

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return res;
    }
}
