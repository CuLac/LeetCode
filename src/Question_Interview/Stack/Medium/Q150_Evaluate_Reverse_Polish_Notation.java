package Question_Interview.Stack.Medium;

/*

150. Evaluate Reverse Polish Notation
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

- The valid operators are '+', '-', '*', and '/'.
- Each operand may be an integer or another expression.
- The division between two integers always truncates toward zero.
- There will not be any division by zero.
- The input represents a valid arithmetic expression in a reverse polish notation.
- The answer and all the intermediate calculations can be represented in a 32-bit integer.

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q150_Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        if (tokens.length == 1 && !set.contains(tokens[0])) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String s : tokens) {
            if (stack.isEmpty() || stack.size() < 2) {
                if (!set.contains(s)) {
                    stack.push(Integer.parseInt(s));
                }
            } else {
                if (set.contains(s)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    res = calculate(a, b, s);
                    stack.push(res);
                } else {
                    stack.push(Integer.parseInt(s));
                }
            }
        }
        return res;
    }

    public static int calculate(int a, int b, String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res = b + a;
                break;
            case "-":
                res = b - a;
                break;
            case "*":
                res = b * a;
                break;
            case "/":
                if (a != 0) {
                    res = b / a;
                }
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));;
    }
}
