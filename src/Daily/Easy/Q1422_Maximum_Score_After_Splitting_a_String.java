package Daily.Easy;

/*
1422. Maximum Score After Splitting a String
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.



Example 1:

Input: s = "011101"
Output: 5
Explanation:
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5
left = "01" and right = "1101", score = 1 + 3 = 4
left = "011" and right = "101", score = 1 + 2 = 3
left = "0111" and right = "01", score = 1 + 1 = 2
left = "01110" and right = "1", score = 2 + 1 = 3
Example 2:

Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
Example 3:

Input: s = "1111"
Output: 3

 */

public class Q1422_Maximum_Score_After_Splitting_a_String {
    public static int maxScore(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int n = s.length();
        int res = 0;
        int curr = 0;
        for (char a : s.toCharArray()) {
            if (a == '1') {
                curr++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                curr++;
            } else {
                curr--;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
