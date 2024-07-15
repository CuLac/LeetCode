package Topic.SlidingWindow.Medium;

/*
1358. Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1

 */


public class Q1358_Number_of_Substrings_Containing_All_Three_Characters {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int res = 0;
        int i = 0;
        int n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;
    }

    /*
    Solution II
        "last" will record the position of last occurrence.
        If the ending index of substring is i,
        the starting position should be on the left of min(last),
        in order to have all 3 different letters.
        And in this case, the starting index can be in range [0, min(last)],
        min(last) + 1 in total.

        Time O(N)
        Space O(1)

     */

    public static int numberOfSubstrings_v2(String s) {
        int[] last = {-1, -1, -1};
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            last[s.charAt(i) - 'a'] = i;
            res += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return res;
    }
}
