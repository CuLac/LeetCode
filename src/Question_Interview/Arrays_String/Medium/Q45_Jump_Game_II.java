package Question_Interview.Arrays_String.Medium;

/*

45. Jump Game II
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

--> 0 <= j <= nums[i] and
--> i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 */

public class Q45_Jump_Game_II {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int n = nums.length - 1;
        int res = 0;
        int start = 0;
        int end = nums[0];
        while (n >= 0) {
            if (end == 0) {
                return 0;
            }
            if (end >= n) {
                return res+1;
            } else {
                int i = 1;
                int rangeMax = i + nums[i + start];
                int indexMax = i;
                int valueMax = nums[i+start];
                while (i <= end) {
                    if(i + nums[i + start] > rangeMax) {
                        rangeMax = i + nums[i + start];
                        indexMax = i;
                        valueMax = nums[i + start];
                    }
                    i++;
                }
                n = n - indexMax;
                start = start + indexMax;
                end = valueMax;
                res++;
            }
        }
        return res;
    }
}
