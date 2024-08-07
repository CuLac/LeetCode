package Question_Interview.BitManipulation;

/*

260. Single Number III
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.



Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]

 */

public class Q260_Single_Number_III {
    public static int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }

        int rightSetBit = res & -res;
        int a = 0;
        for (int n : nums) {
            if ((n & rightSetBit) != 0) {
                a ^= n;
            }
        }

        return new int[] {a, res ^ a};
    }
}
