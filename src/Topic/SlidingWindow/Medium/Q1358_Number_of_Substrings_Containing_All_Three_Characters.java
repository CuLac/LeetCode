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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1358_Number_of_Substrings_Containing_All_Three_Characters {
    public int numberOfSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            String subStr = s.substring(left, right);
            while (left < right && (map.get('a') == 0 || map.get('b') == 0 || map.get('c') == 0)) {

            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
