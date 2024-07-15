package Question_Interview.Arrays_String.Medium;

/*

151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 */


import com.google.gson.Gson;

import java.util.Stack;

public class Q151_Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        for (String item : s.split(" ")) {
            stack.push(item);
        }
        System.out.println(stack);
        StringBuilder stb = new StringBuilder();
        while (!stack.isEmpty()) {
            String item = stack.peek();
            System.out.println("Item=" + item);
            if (!item.equals("")) {
                System.out.println("Item not equal space");
                if (stb.length() != 0) {
                    stb.append(" ");
                }
                stb.append(item.trim());
            }
            System.out.println(stb);
            stack.pop();
        }
        String result = stb.toString();
        if (result.length() > 0) {
            result.trim();
        }
        System.out.println(result);
        return result;
    }
}
