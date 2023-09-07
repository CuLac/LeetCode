package Question_Interview.KadaneAlgorithm;

/*

53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.


Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.



Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.



Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 */

public class Q53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int max_ending_here  = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here += nums[i];
            if (max < max_ending_here) {
                max = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max;
    }
}
