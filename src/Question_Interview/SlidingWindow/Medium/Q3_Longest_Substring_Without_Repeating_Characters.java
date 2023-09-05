package Question_Interview.SlidingWindow.Medium;

/*

3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

import java.util.HashMap;

public class Q3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        int c = 0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                int idx = map.get(s.charAt(i));
                if (idx >= j) {
                    c = i - idx;
                    j = idx + 1;
                } else {
                    c++;
                }
            } else {
                c++;
            }
            ans = Math.max(ans, c);
            map.put(s.charAt(i), i);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
