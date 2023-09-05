package Question_Interview.HashMap.Medium;

/*

49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

 */

import java.util.*;

public class Q49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String item : strs) {
            char [] arr = item.toCharArray();
            //tao key tong quat cho cac string dao tu`
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (map.containsKey(key)) {
                //lay danh sach cac tu trong list dao tu`
                List<String> temp = map.get(key);
                temp.add(item);
                map.put(key, temp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(item);
                map.put(key, list);
            }
        }
        for (Map.Entry<String, List<String>> item : map.entrySet()) {
            res.add(item.getValue());
        }
        return res;
    }
}
