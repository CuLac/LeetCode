package Daily.Easy;

/*
645. Set Mismatch
You have a set of integers s, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.



Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]


Example 2:

Input: nums = [1,1]
Output: [1,2]

 */

import com.google.gson.Gson;

import java.util.Arrays;

public class Q645_Set_Mismatch {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp, 0);
        int diff = n * (n+1) / 2;
        int [] res = new int[2];
        for (int i = 0; i < n; i++) {
            dp[nums[i]]++;
            if (dp[nums[i]] > 1) {
                res[0] = nums[i];
            }
            diff -= nums[i];
        }
        res[1] = res[0] + diff;
        return res;
    }
}
