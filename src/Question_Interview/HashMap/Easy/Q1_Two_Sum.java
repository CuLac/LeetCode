package Question_Interview.HashMap.Easy;

/*

1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 */

import java.util.HashMap;
import java.util.Map;

public class Q1_Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            while (j < nums.length - 1) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    res[0] = i;
                    res[0] = j;
                    return res;
                }
                j++;
            }
            i++;
        }
        return res;
    }

    public static int[] twoSum_v2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }
        System.out.println(numMap);

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }

    //the best solution
    public int[] twoSum_v3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        int [] arr = {3, 3};
        twoSum_v2(arr, 6);
    }
}
