package Question_Interview.SlidingWindow.Hard;

/*

30. Substring with Concatenation of All Words
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
"acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
The output order does not matter. Returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
We return an empty array.
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30_Substring_with_Concatenation_of_All_Words {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        }
        if (words.length == 0) {
            return ans;
        }
        int totalLength = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> currentMap = new HashMap<>();
        for (String item : words) {
            map.put(item, map.getOrDefault(item, 0) + 1);
            totalLength += item.length();
        }
        if (s.length() < totalLength) {
            return ans;
        }
        int i = 0;
        int count = words[0].length();
        while (i < s.length() - totalLength + 1) {
            String substr = s.substring(i, i + totalLength);
            currentMap.clear();
            if (checkString(substr, currentMap, map, count)) {
                ans.add(i);
            }
            i++;
        }
        return ans;
    }

    public static boolean checkString(String substr, HashMap<String, Integer> currentMap, HashMap<String, Integer> map, int count) {
        while (substr.length() > 0) {
            String temp = substr.substring(0, count);
            substr = substr.substring(count);
            currentMap.put(temp, currentMap.getOrDefault(temp, 0) + 1);
        }
        return currentMap.equals(map);
    }

    public List<Integer> findSubstring_v2(String s, String[] words) {

        // Edge case: return an empty list if the input string is empty or the array of words is empty
        if (s.isEmpty() || words.length == 0) {
            return new ArrayList<>();
        }

        // Initialize a list to store the starting indices of the concatenated substrings
        List<Integer> indices = new ArrayList<>();

        // Initialize a map to store the counts of each word in the array of words
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Initialize a map to store the counts of each word in the current substring
        Map<String, Integer> currentCounts = new HashMap<>();

        // Initialize variables to keep track of the length of each word and the total length of all the words
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        // Loop through the input string, checking for concatenated substrings at each position
        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            // Initialize the current counts map for the new substring
            currentCounts.clear();

            // Loop through the words in the current substring and update their counts in the current counts map
            for (int j = 0; j < words.length; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                currentCounts.put(word, currentCounts.getOrDefault(word, 0) + 1);
            }

            // Check if the current counts map is equal to the original word counts map
            if (currentCounts.equals(wordCounts)) {
                // If they are equal, add the starting index of the current substring to the list of indices
                indices.add(i);
            }
        }

        // Return the list of indices
        return indices;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String [] arr = {"bar","foo","the"};
        System.out.println(findSubstring(s, arr));
    }
}
