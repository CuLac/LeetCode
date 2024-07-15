package Topic.SlidingWindow.Medium;

/*
930. Binary Subarrays With Sum
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15

 */

public class Q930_Binary_Subarrays_With_Sum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0, n = nums.length;
        int i = 0;
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == 1) {
                --goal;
                count = 0;
            }
            while (i < n && goal == 0) {
                goal += nums[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }
}
