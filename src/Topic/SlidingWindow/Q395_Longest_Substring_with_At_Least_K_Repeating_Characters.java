package Topic.SlidingWindow;

/*

395. Longest Substring with At Least K Repeating Characters
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of
each character in this substring is greater than or equal to k.

if no such substring exists, return 0.



Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

 */

public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return s.length();
        }
        return 0;
    }
}
