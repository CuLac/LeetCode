package Daily.Easy;

/*
1903. Largest Odd Number in String
You are given a string num, representing a large integer.
Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
Example 2:

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".
Example 3:

Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.

 */

public class Q1903_Largest_Odd_Number_in_String {
    public static String largestOddNumber(String num) {
        if(num.length() < 1) {
            return "";
        }
        int n = num.length();
        while (n > 0) {
            char lastDigit = num.charAt(n - 1);
            if (Character.isDigit(lastDigit)) {
                if ((lastDigit - '0') % 2 == 1) {
                    return num.substring(0, n);
                }
            }
            n--;
        }
        return "";
    }
}