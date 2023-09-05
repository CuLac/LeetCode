package Question_Interview.Stack.Easy;

/*

20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

 */

import java.util.Stack;

public class Q20_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char [] arr = s.toCharArray();
        for (char a : arr) {
            if (!stack.isEmpty() && (stack.peek() == a - 1 || stack.peek() == a - 2)) {
                stack.pop();
            } else
                stack.push(a);
        }
        return stack.isEmpty();
    }

    public boolean isValid_v2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


}
