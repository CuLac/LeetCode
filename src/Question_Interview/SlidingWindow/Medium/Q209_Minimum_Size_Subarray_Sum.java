package Question_Interview.SlidingWindow.Medium;

/*

209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


 */

public class Q209_Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {
        int i = -1,j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int c = 0;
        while(i < nums.length){
            if(sum >= target){
                ans = Math.min(ans,c);
                sum -= nums[j];
                j++;
                c--;
            }
            else{
                i++;
                if(i < nums.length){
                    sum+=nums[i];
                    c++;
                }
            }
        }
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        return ans;
    }

    public int minSubArrayLen_v2(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;

        for(right = 0; right < nums.length; right++) {
            sumOfCurrentWindow += nums[right];

            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
