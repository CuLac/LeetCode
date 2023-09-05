package Question_Interview.Arrays_String.Easy;

/*

28. Find the Index of the First Occurrence in a String
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

 */

public class Q28_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        // quét chuỗi haystack
        for (int i = 0; i < haystack.length(); i++) {

            /*
            Neu ki tu thu i cua chuoi haystack la ki tu dau tien cua chuoi needle

            ==> so sanh 2 chuoi bat dau tu vi tri thu i cua chuoi haystack
             */
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; i+j < haystack.length() && j < needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
