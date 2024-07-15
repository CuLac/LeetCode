package Daily.Medium;

/*
2966. Divide Array Into Arrays With Max Difference
You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array.
And if there are multiple answers, return any of them.



Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.
Example 2:

Input: nums = [1,3,3,2,7,3], k = 3
Output: []
Explanation: It is not possible to divide the array satisfying all the conditions.

 */

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class Q2966_Divide_Array_Into_Arrays_With_Max_Difference {
    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n % 3 != 0) {
            return new int[1][1];
        }
        int div = n / 3;
        int [][] res = new int[div][3];
        int i = 0;
        int j = 0;
        for (int val : nums) {
            if (j != 0 && val - res[i][0] > k) {
                return new int[1][1];
            } else {
                res[i][j++] = val;
            }

            if (j == 3) {
                i++;
                j = 0;
            }
        }
        return res;
    }
}
