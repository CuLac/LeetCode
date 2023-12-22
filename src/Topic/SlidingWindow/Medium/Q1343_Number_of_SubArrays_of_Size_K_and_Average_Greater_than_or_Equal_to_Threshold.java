package Topic.SlidingWindow.Medium;

/*
1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.



Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
All other sub-arrays of size 3 have averages less than 4 (the threshold).


Example 2:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.

 */

public class Q1343_Number_of_SubArrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int comp = k * threshold;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            sum+= arr[i];
        }
        res += (sum >= comp) ? 1 : 0;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            res += (sum >= comp) ? 1 : 0;
        }
        return res;
    }
}
