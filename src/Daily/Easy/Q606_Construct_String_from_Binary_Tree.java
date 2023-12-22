package Daily.Easy;

/*
606. Construct String from Binary Tree
Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.



Example 1:


Input: root = [1,2,3,4]
Output: "1(2(4))(3)"
Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)"
Example 2:


Input: root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break
the one-to-one mapping relationship between the input and the output.

 */

import Daily.TreeNode;
import com.google.gson.Gson;

public class Q606_Construct_String_from_Binary_Tree {
    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stb = new StringBuilder();
        readNote(root, stb);
        return stb.toString();
    }

    public static void readNote(TreeNode t, StringBuilder res) {
        if (t == null)
            return;
        res.append(t.val);
        if (t.left == null && t.right == null)
            return;
        res.append('(');
        readNote(t.left, res);
        res.append(')');
        if (t.right != null) {
            res.append('(');
            readNote(t.right, res);
            res.append(')');
        }
    }
}
