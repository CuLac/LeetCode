package Topic.SlidingWindow.Medium;

/*
1695. Maximum Erasure Value
You are given an array of positive integers nums and want to erase a subarray containing unique elements.
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).



Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

 */

import java.util.Arrays;

public class Q1695_Maximum_Erasure_Value {
    public static int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int [] dp = new int[100001];
        Arrays.fill(dp, 0);
        int left = 0;
        int curr = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            dp[nums[right]]++;
            curr += nums[right];
            while (dp[nums[right]] > 1) {
                curr -= nums[left];
                dp[nums[left]]--;
                left++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
