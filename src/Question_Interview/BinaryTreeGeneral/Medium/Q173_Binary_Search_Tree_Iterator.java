package Question_Interview.BinaryTreeGeneral.Medium;

/*

173. Binary Search Tree Iterator
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor.
The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.



Example 1:

Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False

 */


/*

Solution
I use Stack to store directed left children from root.
When next() be called, I just pop one element and process its right child as new root.
The code is pretty straightforward.

So this can satisfy O(h) memory, hasNext() in O(1) time,
But next() is O(h) time.

I can't find a solution that can satisfy both next() in O(1) time, space in O(h).

 */

import Question_Interview.BinaryTreeGeneral.TreeNode;

import java.util.Stack;

public class Q173_Binary_Search_Tree_Iterator {
    private Stack<TreeNode> stack = new Stack<>();

    public Q173_Binary_Search_Tree_Iterator(TreeNode root) {
        TreeNode curr = root;
        stack = new Stack();
        while (curr != null) {
            stack.push(curr);
            if (curr.left != null) {
                curr = curr.left;
            } else
                break;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        // traversal right branch
        if(cur.right != null){
            cur = cur.right;
            while(true){
                stack.push(cur);
                if(cur.left != null)
                    cur = cur.left;
                else
                    break;
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
