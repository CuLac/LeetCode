package Daily.BinarySearch;

/*

2616. Minimize the Maximum Difference of Pairs
You are given a 0-indexed integer array nums and an integer p.
Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized.
Also, ensure no index appears more than once amongst the p pairs.

Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.



Example 1:

Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5.
The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.


Example 2:

Input: nums = [4,2,1,2], p = 1
Output: 0
Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2616_Minimize_the_Maximum_Difference_of_Pairs {
    public int minimizeMax(int[] nums, int p) {
        if (nums.length == 0 || p == 0) {
            return 0;
        }
        if (nums.length < p * 2) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n-1] - nums[0];

        /*
            sau khi sắp xếp khoảng cách lớn nhất giữa 2 số ==> nums[n-1] - nums[0]
            ---> dùng binary search tim khoang cach lon nhat thoa man tim dc p cap so' có khoảng cách nhỏ hơn (left+right)/2
         */

        while (left < right) {
            int mid = (left + right) / 2;
            if (canformPair(nums, mid, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canformPair(int[] nums, int mid, int p) {
        int count = 0;
        for (int i = 0; i < nums.length - 1 && count < p;) {
            if (nums[i+1] - nums[i] < mid) {
                count++;
                i+=2;
            }
        }
        return count >= p;
    }
}
