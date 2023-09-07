package Question_Interview.BitManipulation;

/*

137. Single Number II
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

 */

import java.util.HashMap;
import java.util.Map;

public class Q137_Single_Number_II {
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (final int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }

        return ones;
    }

    /*

    The usual bit manipulation code is bit hard to get and replicate.
    I like to think about the number in 32 bits and just count how many 1s are there in each bit,
    and sum %= 3 will clear it once it reaches 3.
    After running for all the numbers for each bit, if we have a 1, then that 1 belongs to the single number,
    we can simply move it back to its spot by doing ans |= sum << i;

    This has complexity of O(32n), which is essentially O(n) and very easy to think and implement.
    Plus, you get a general solution for any times of occurrence. Say all the numbers have 5 times, just do sum %= 5.

     */
    public static int singleNumber_v2(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }

    public int singleNumber_v3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0,1,0,1,99};
        System.out.println(singleNumber_v2(arr));
    }
}
