package Daily.Easy;

/*

168. Excel Sheet Column Title
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:

Input: columnNumber = 1
Output: "A"


Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"

 */

public class Q168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        if (n >= 1 && n <= 26) return ((char)('A' + n - 1)) + "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % 26;
            if (r == 0) {
                sb.append('Z');
            } else {
                sb.append((char) ('A' + r - 1));
            }
            n /= 26;
            if (r == 0) {
                n--;
            }
        }
        return sb.reverse().toString();
    }
}
