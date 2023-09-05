package Question_Interview.HashMap.Medium;

/*

128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q128_Longest_Consecutive_Sequence {


    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i+1] - nums[i] == 1) {
                count ++;
                res = Math.max(res, count);
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return res;
    }

    public int longestConsecutive_v2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int res = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            int count = 1;
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }
            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public int longestConsecutive_v3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) val--;
                sum += num - val;

                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
