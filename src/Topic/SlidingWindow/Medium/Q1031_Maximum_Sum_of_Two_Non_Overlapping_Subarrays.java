package Topic.SlidingWindow.Medium;

/*
1031. Maximum Sum of Two Non-Overlapping Subarrays
Given an integer array nums and two integers firstLen and secondLen,
return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.

The array with length firstLen could occur before or after the array with length secondLen, but they have to be non-overlapping.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
Example 2:

Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
Output: 29
Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
Example 3:

Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
Output: 31
Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [0,3,8] with length 3.

 */

public class Q1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays {
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        if (firstLen < secondLen) {
            int tmp = firstLen;
            firstLen = secondLen;
            secondLen = tmp;
        }
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        int res = 0;
        for (int i = 0; i < firstLen; i++) {
            sum1 += nums[i];
        }
        sum2 = sum(nums, firstLen, n, secondLen);
        res = Math.max(res, sum1 + sum2);
        for (int i = firstLen; i < n; i++) {
            sum1 += nums[i] - nums[i - firstLen];
            sum2 = 0;
            if (n - i > secondLen) {
                sum2 = sum(nums, i + 1, n, secondLen);
            }
            if (i - firstLen >= secondLen) {
                sum2 = Math.max(sum2, sum(nums, 0, i - firstLen, secondLen));
            }
            res = Math.max(res, sum1 + sum2);
        }
        return res;
    }

    public static int sum(int [] nums, int start, int end, int length) {
        int curr = 0;
        for (int i = start; i < start + length; i++) {
            curr += nums[i];
        }
        int res = curr;
        for (int i = start + length; i < end; i++) {
            curr += nums[i] - nums[i - length];
            res = Math.max(res, curr);
        }
        return res;
    }
}
