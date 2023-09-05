package Daily.Medium;

/*

46. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        permuteRec(nums, 0, res);
        return res;
    }

    public void permuteRec(int[] nums, int begin, List<List<Integer>> result) {
        if (begin == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            result.add(temp);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            // Swap
            int temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;

            permuteRec(nums, begin + 1, result);

            // Swap back
            temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;
        }
    }
}
