package Question_Interview.Two_Pointer.Easy;

/*

392. Is Subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


 */

public class Q392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int l = s.length();
        int r = t.length();
        int k = 0;

        if (l == 0) {
            return true;
        }

        if (l > r) {
            return false;
        }

        for (int i = 0; i < r; i++) {
            if (s.charAt(k) == t.charAt(i)) {
                if (k == l - 1) {
                    return true;
                }
                k++;
            }
        }

        return false;
    }
}
