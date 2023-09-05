package Question_Interview.HashMap.Easy;

/*

383. Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

 */

import java.util.HashMap;

public class Q383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char item : magazine.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (char item : ransomNote.toCharArray()) {
            if (!map.containsKey(item) || map.get(item) == 0) {
                return false;
            } else {
                map.put(item, map.get(item) - 1);
            }
        }
        return true;
    }
}
