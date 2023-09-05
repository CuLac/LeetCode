package Question_Interview.HashMap.Easy;

/*

205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true

 */

import java.util.HashMap;

public class Q205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        char [] arr1 = s.toCharArray();
        char [] arr2 = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                if (arr2[i] != map.get(arr1[i])) {
                    return false;
                }
            }
            else {
                if (!map.containsValue(arr2[i])) {
                    map.put(arr1[i], arr2[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
