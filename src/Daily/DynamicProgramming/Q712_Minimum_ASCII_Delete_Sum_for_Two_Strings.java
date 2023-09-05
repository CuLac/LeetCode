package Daily.DynamicProgramming;

/*

712. Minimum ASCII Delete Sum for Two Strings
Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.



Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.


Approach

The solution utilizes dynamic programming to find the minimum ASCII delete sum of s1 and s2.
A 2D DP array dp is used to store the minimum delete sum for subproblems.

The recursive function solve is defined, which takes four parameters: i and j are the current indices for s1 and s2,
respectively, and s1 and s2 are the input strings.

In the solve function, the following steps are followed:

a. Check if the value for the current state (i, j) is already computed and stored in the dp array.
If yes, return the value to avoid recomputation.

b. If i reaches the end of s1, it means all characters of s1 have been processed.
In this case, sum the ASCII values of the remaining characters in s2 (from index j to the end) and return the sum. These characters need to be deleted to make s1 and s2 equal.

c. If j reaches the end of s2, it means all characters of s2 have been processed. Similar to the previous case,
sum the ASCII values of the remaining characters in s1 (from index i to the end) and return the sum.

d. If neither i nor j has reached the end of their respective strings, then two options are possible:

Calculate the sum of the ASCII value of the current character of s1 with the minimum delete sum of the remaining characters of s1 and s2
(by calling the solve function recursively with i+1 and j).

Calculate the sum of the ASCII value of the current character of s2 with the minimum delete sum of the remaining characters of s1 and s2
(by calling the solve function recursively with i and j+1).

If the current characters of s1 and s2 are equal, an additional option is available:

Calculate the minimum delete sum of the remaining characters of s1 and s2 (by calling the solve function recursively with i+1 and j+1)
without including the current characters in the sum since they are already equal.
e. Return the minimum of the above three options as the minimum delete sum for the current state (i, j) and store it in the dp array for future reference.

 */

import java.util.Arrays;

public class Q712_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, 0, 0);
    }

    private int solve(String s1, String s2, int i, int j) {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }
            return sum;
        }
        int nt = Math.min(s1.charAt(i) + solve(s1, s2, i + 1, j), s2.charAt(j) + solve(s1, s2, i, j + 1));
        int tk = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {
            tk = solve(s1, s2, i + 1, j + 1);
        }
        return dp[i][j] = Math.min(nt, tk);
    }

    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";
        System.out.println();
    }
}
