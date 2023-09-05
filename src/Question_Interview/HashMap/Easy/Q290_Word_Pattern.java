package Question_Interview.HashMap.Easy;

/*

290. Word Pattern
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

 */

import java.util.HashMap;

public class Q290_Word_Pattern {
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        char [] charArr = pattern.toCharArray();
        if (arr.length != charArr.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < charArr.length; i++) {
            if (map.containsKey(charArr[i])) {
                if (!map.get(charArr[i]).equals(arr[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(arr[i])) {
                    return false;
                } else
                    map.put(charArr[i], arr[i]);
            }
        }
        return true;
    }
}
