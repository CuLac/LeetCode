package Question_Interview.BitManipulation;

/*

136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

 */

public class Q136_Single_Number {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i :nums) {
            res = res ^ i;
        }
        return res;
    }
}
