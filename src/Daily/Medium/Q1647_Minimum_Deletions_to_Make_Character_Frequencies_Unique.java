package Daily.Medium;

/*

1647. Minimum Deletions to Make Character Frequencies Unique
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string.
For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).

 */

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    public static int minDeletions(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("Map=" + new Gson().toJson(map));
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
            int val = entrySet.getValue();
            while (set.contains(val) && val != 0) {
                val--;
                res++;
            }
            set.add(val);
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "bbcebab";
        System.out.println(minDeletions(s));
    }
}
