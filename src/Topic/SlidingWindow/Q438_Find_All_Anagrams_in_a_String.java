package Topic.SlidingWindow;

/*

438. Find All Anagrams in a String
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".


Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */

import com.google.gson.Gson;

import java.util.*;

public class Q438_Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) {
            return list;
        }
        if (s.length() < 1 || p.length() < 1) {
            return list;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char a : p.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println("Map=" + new Gson().toJson(map));
        int n = s.length();
        int k = p.length();
        int start = 0;
        int end = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        while (end < n) {
            System.out.println("Start=" + start + "|End=" + end);
            while (end - start < k) {
                char a = s.charAt(end);
                map1.put(a, map1.getOrDefault(a, 0) + 1);
                end++;
            }
            System.out.println("Map1=" + new Gson().toJson(map1));
            if (map1.equals(map)) {
                char first = s.charAt(start);
                list.add(start);
                map1.remove(first);
                start = start + 1;
            } else {
                end--;
                if (!map.containsKey(s.charAt(end))) {
                    map1.clear();
                    start = end + 1;
                    end = end + 1;
                } else {
                    if (map1.getOrDefault(s.charAt(start), 0) == 1) {
                        map1.remove(s.charAt(start));
                    } else {
                        map1.put(s.charAt(start), map1.get(s.charAt(start)) - 1);
                    }
                    start = start + 1;
                    end = end + 1;
                }
            }

        }
        return list;
    }


    /**
     * Sliding window (In this solution windows of size = p.length() is always
     * maintained.)
     *
     * Time Complexity: O(S + P)
     *
     * Space Complexity: O(P). We only save unique characters in P. It will be O(1)
     * as there are only 26 alphabets.
     *
     * S = Length of input string s. P = Length of input string p.
     */


    public List<Integer> findAnagrams_v2(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen * pLen == 0 || sLen < pLen) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        int toBeMatched = map.size();
        int start = 0;
        int end = 0;

        while (end < sLen) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                int count = map.get(eChar);
                if (count == 1) {
                    toBeMatched--;
                }
                map.put(eChar, count - 1);
            }
            end++;

            if (end - start > pLen) {
                char sChar = s.charAt(start);
                if (map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if (count == 0) {
                        toBeMatched++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }

            if (toBeMatched == 0) {
                result.add(start);
            }
        }

        return result;
    }
}
