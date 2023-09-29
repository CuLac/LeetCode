package Topic.SlidingWindow;

/*

567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").


Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q567_Permutation_in_String {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int [] dp1 = new int[26];
        Arrays.fill(dp1, 0);
        int [] dp2 = new int[26];
        Arrays.fill(dp2, 0);
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            dp1[s1.charAt(i) - 'a']++;
            dp2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(dp1, dp2)) return true;
        int start = 0;
        int end = n;
        while (end < s2.length()) {
            dp2[s2.charAt(end) - 'a']++;
            dp2[s2.charAt(start) - 'a']--;
            if (Arrays.equals(dp1, dp2)) {
                return true;
            }
            start++;
            end++;
        }
        return false;
    }
}
