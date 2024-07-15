package Topic.SlidingWindow.Medium;

/*
2799. Count Complete Subarrays in an Array
You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.



Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].


Example 2:

Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.

 */

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

public class Q2799_Count_Complete_Subarrays_in_an_Array {
    public static int countCompleteSubarrays(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
            max = Math.max(max, i);
        }
        int [] dp = new int[max+1];

        int res = 0;
        int idx = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            dp[nums[i]]++;
            while (checkValid(dp, set)) {
                --dp[nums[idx++]];
            }
            res += idx;
        }
        return res;
    }

    private static boolean checkValid(int [] dp, Set<Integer> set) {
        for (int i : set) {
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
