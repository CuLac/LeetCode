package Question_Interview.Arrays_String.Easy;

/*

14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 */

import java.util.Arrays;

public class Q14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        //simple resolve
        String pre = strs[0];

        if(pre.isEmpty()){
            return "";
        }

        for(int i = 0 ;i < strs.length; i++){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }
}
