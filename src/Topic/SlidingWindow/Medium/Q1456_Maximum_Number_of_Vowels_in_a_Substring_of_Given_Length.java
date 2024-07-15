package Topic.SlidingWindow.Medium;

/*
1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int curr = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                curr++;
            }
        }

        int res = curr;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                curr++;
            }
            if (set.contains(s.charAt(i - k))) {
                curr--;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    public int maxVowels_v2(String s, int k) {
        int [] dp = new int[26];
        Arrays.fill(dp, 0);
        dp[0] = dp['e' - 'a'] = dp['i' - 'a'] = dp['o' - 'a'] = dp['u' - 'a'] = 1;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += dp[s.charAt(i) - 'a'];
        }
        int res = curr;
        for (int i = k; i < s.length(); i++) {
            curr += dp[s.charAt(i) - 'a'] - dp[s.charAt(i - k) - 'a'];
            res = Math.max(res, curr);
        }
        return res;
    }

    public int maxVowels_v3(String s, int k) {
        int i = 0, j = 0, n = s.length();
        int maxNoOfVowel = 0, countOfVowel = 0;

        byte[] str = new byte[n];
        s.getBytes(0, n, str, 0);
        byte [] vowel = new byte[123];
        vowel['a'] = vowel['e'] = vowel['u'] = vowel['i'] = vowel['o'] = 1;

        while (i < k) {
            countOfVowel += vowel[str[i++]];
        }
        maxNoOfVowel = countOfVowel;

        while (i < n) {
            if ((countOfVowel += vowel[str[i++]] - vowel[str[j++]]) >  maxNoOfVowel
                    && (maxNoOfVowel = countOfVowel) == k) {
                return k;
            }
        }
        return maxNoOfVowel;
    }
}
