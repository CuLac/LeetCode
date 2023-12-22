package Daily.Easy;

/*

557. Reverse Words in a String III
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"

 */

import java.util.Stack;

public class Q557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        if (s.length() < 2) {
            return s;
        }
        char [] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder stb = new StringBuilder();
        for (char c : arr) {
            if (Character.isWhitespace(c)) {
                while (!stack.isEmpty()) {
                    stb.append(stack.pop());
                }
                stb.append(c);
            } else {
                stack.add(c);
            }
        }
        while(!stack.isEmpty()) {
            stb.append(stack.pop());
        }
        return stb.toString();
    }

    public String reverseWords_v2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        char [] arr = s.toCharArray();
        int n = arr.length;
        while (end < n) {
            while (end < n && arr[end] != ' ') {
                end++;
            }

            reverse(arr, start, end - 1);

            start = end + 1;
            end++;
        }
        return new String(arr);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
