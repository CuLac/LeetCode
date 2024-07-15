package Daily.Easy;

/*
387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1

 */

import java.util.*;

public class Q387_First_Unique_Character_in_a_String {
    public static int firstUniqChar(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(s.charAt(i))) {
                list = map.get(s.charAt(i));
            }
            list.add(i);
            map.put(s.charAt(i), list);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, List<Integer>> entrySet : map.entrySet()) {
            if (entrySet.getValue().size() == 1) {
                res = Math.min(res, entrySet.getValue().get(0));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int firstUniqChar_v2(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
