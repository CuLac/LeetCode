package Daily.Easy;

/*

896. Monotonic Array
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.



Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false

 */

public class Q896_Monotonic_Array {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            int temp = nums[i] - nums[i-1];
            if (diff == 0) {
                diff = nums[i] - nums[i-1];
            } else {
                if (temp*diff < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
