package Question_Interview.DynamicPrograming.Medium;

/*

300. Longest Increasing Subsequence
Given an integer array nums, return the length of the longest strictly increasing
subsequence
.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.



Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4



Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 */

/*

    Solution

    dp is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

    len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    len = 3   :      [4, 5, 6]            => tails[2] = 6
    We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

    Each time we only do one of the two:

    (1) if x is larger than all tails, append it, increase the size by 1
    (2) if tails[i-1] < x <= tails[i], update tails[i]
    Doing so will maintain the tails invariant. The the final answer is just the size.

 */

import java.util.Arrays;

public class Q300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int n = nums.length;
        int [] dp = new int[n];
        int max = 0;
        for (int x : nums) {
            int i = 0, j = max;
            while (i != j) {
                int m = (i + j) / 2;
                if (dp[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            dp[i] = x;
            if (i == max) ++max;
        }
        return max;
    }

    public static void main(String[] args) {
        int i = Arrays.binarySearch(new int[10], 0, 10, 5);
    }
}
