package Topic.SlidingWindow.Easy;

/*
1763. Longest Nice Substring
A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear.
However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice.
If there are multiple, return the substring of the earliest occurrence.
If there are none, return an empty string.



Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.

 */

import java.util.HashSet;
import java.util.Set;

public class Q1763_Longest_Nice_Substring {
    public String longestNiceSubstring(String s) {
        int[] sub = longestNiceSubstring(s, 0, s.length());
        return s.substring(sub[0], sub[1]);
    }

    private int[] longestNiceSubstring(String s, int left, int right) {
        Set<Character> charSet = getCharSet(s, left, right);

        for (int i = left; i < right; i++)
            if (!charSet.contains(Character.toLowerCase(s.charAt(i)))
                    || !charSet.contains(Character.toUpperCase(s.charAt(i)))) {

                int[] prefix = longestNiceSubstring(s, left, i);
                int[] suffix = longestNiceSubstring(s, i + 1, right);
                return prefix[1] - prefix[0] >= suffix[1] - suffix[0]
                        ? prefix
                        : suffix;
            }

        return new int[]{left, right};
    }

    private Set<Character> getCharSet(String s, int left, int right) {
        Set<Character> charSet = new HashSet<>();

        for (int i = left; i < right; i++)
            charSet.add(s.charAt(i));

        return charSet;
    }
}
