package Daily.Medium;

/*
1143. Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.
If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none)
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

 */

public class Q1143_Longest_Common_Subsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (text1.length() < text2.length()) {
            String tmp = text1;
            text1 = text2;
            text2 = tmp;
        }

        char [] arr1 = text1.toCharArray();
        char [] arr2 = text2.toCharArray();
        int n = arr1.length;
        int m = arr2.length;
        int [] dp1 = new int[n];
        int [] dp2 = new int[m];

        for (int i = 0; i < m; i++) {
            dp2[arr1[i] - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < n;i++) {
            if (dp2[arr1[i] - 'a'] > 0) {
                res++;
                dp2[arr1[i] - 'a']--;
            }
        }

        return res;
    }
}
