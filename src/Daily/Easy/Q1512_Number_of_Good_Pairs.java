package Daily.Easy;

/*

1512. Number of Good Pairs
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0

 */

import java.util.HashMap;
import java.util.Map;

public class Q1512_Number_of_Good_Pairs {
    public static int numIdenticalPairs(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            res += numbPermution(entrySet.getValue());
        }
        return res;
    }

    public static int numbPermution(int n) {
        if (n == 0) {
            return 0;
        }
        int [] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i-1] + i;
        }
        return res[n];
    }

    public int numIdenticalPairs_v2(int[] nums) {
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j])
        //             count++;
        //     }
        // }
        // return count;

        int count=0;
        Map<Integer,Integer> map=new HashMap<>();

        for(int num: nums){
            int isFoundCount=map.getOrDefault(num,0);
            count+=isFoundCount;
            map.put(num,isFoundCount+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(arr));
    }
}
