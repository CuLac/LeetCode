package Daily.Easy;

/*
1614. Maximum Nesting Depth of the Parentheses
A string is a valid parentheses string (denoted VPS) if it meets one of the following:

It is an empty string "", or a single character not equal to "(" or ")",
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
We can similarly define the nesting depth depth(S) of any VPS S as follows:

depth("") = 0
depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

Given a VPS represented as string s, return the nesting depth of s.



Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation: Digit 8 is inside of 3 nested parentheses in the string.
Example 2:

Input: s = "(1)+((2))+(((3)))"
Output: 3

 */


/*
Intuition
To find the nesting depth of the given VPS string s, we can iterate through each character of the string and keep track of the current nesting depth. Whenever we encounter an opening parenthesis '(', we increment the depth, and whenever we encounter a closing parenthesis ')', we decrement the depth. We update the maximum depth encountered so far accordingly.
Approach
1. Initialize variables count and max_num to keep track of the current depth and maximum depth encountered so far, respectively. Set both to 0.
2. Iterate through each character i in the input string s.
3. If i is '(', increment count by 1 and update max_num if count exceeds it.
4. If i is ')', decrement count by 1.
5. Finally, return max_num, which represents the maximum nesting depth.
Complexity
Time complexity:
O(n)O(n)O(n), where n is the length of the input string s. We traverse the entire string once.
Space complexity:
O(1)O(1)O(1), as we only use a constant amount of extra space for variables count and max_num.


 */

public class Q1614_Maximum_Nesting_Depth_of_the_Parentheses {
    public int maxDepth(String s) {
        int count = 0;
        int maxNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (maxNum < count)
                    maxNum = count;
            } else if (c == ')') {
                count--;
            }
        }
        return maxNum;
    }
}
