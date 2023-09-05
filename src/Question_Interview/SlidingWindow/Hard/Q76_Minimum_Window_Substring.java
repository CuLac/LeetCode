package Question_Interview.SlidingWindow.Hard;

/*

76. Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window
substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.


Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

 */

import com.google.gson.Gson;

public class Q76_Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return "";
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        System.out.println("Chs=" + new Gson().toJson(chS));
        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            /*
                same way:
                if (map[chS[end]] > 0) {
                    count--;
                }
                map[s[end]]--;
                end++;

             */

            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }

                /*
                    same way:
                    if (map[chS[start]] == 0) {
                        count++;
                    }
                    map[chS[start]]++;
                    start++;

                 */
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(chS, startIndex, minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        minWindow(s, t);
    }
}
