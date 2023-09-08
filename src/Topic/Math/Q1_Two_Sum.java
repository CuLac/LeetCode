package Topic.Math;

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

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Q1_Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int idx = 0;
        for (int i : nums) {
            map.put(i, idx++);
        }
        System.out.println(new Gson().toJson(map));
        idx = 0;
        for (int i : nums) {
            int res = target - i;
            if (map.containsKey(res) && map.get(res) != idx) {
                return new int[]{i, res};
            }
            idx++;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
        System.out.println(new Gson().toJson(twoSum(arr, 9)));
    }
}
