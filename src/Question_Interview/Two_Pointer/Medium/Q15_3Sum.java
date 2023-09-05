package Question_Interview.Two_Pointer.Medium;

/*

15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i + 1;
                int k = nums.length - 1;
                int num1 = nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] + num1 == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(num1);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        list.add(temp);
                        while (nums[j] == nums[j+1] && j+1 < k) {
                            j++;
                        }
                        while (nums[k] == nums[k-1] && j< k - 1) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] + num1 < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return list;
    }
}
