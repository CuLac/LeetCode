package Daily.Hard;

/*

1326. Minimum Number of Taps to Open to Water a Garden
There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.

Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can
water the area [i - ranges[i], i + ranges[i]] if it was open.

Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.



Example 1:


Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1
Explanation: The tap at point 0 can cover the interval [-3,3]
The tap at point 1 can cover the interval [-3,5]
The tap at point 2 can cover the interval [1,3]
The tap at point 3 can cover the interval [2,4]
The tap at point 4 can cover the interval [4,4]
The tap at point 5 can cover the interval [5,5]
Opening Only the second tap will water the whole garden [0,5]




Example 2:

Input: n = 3, ranges = [0,0,0,0]
Output: -1
Explanation: Even if you activate all the four taps you cannot water the whole garden.

 */


/*

Intuition and Logic Behind the Solution
The problem challenges us to water an entire one-dimensional garden using the fewest number of taps.
Each tap has a range that it can water.
The crux of our solution is to always choose the tap that allows us to water the farthest point in the garden that hasn't been watered yet.

Why Greedy?
The greedy approach works well in this situation because it aims to make the best local choices in the hope of reaching an optimal global solution.
In this context, each local choice is to open a tap that extends our watering range as far as possible.
By doing so, we minimize the total number of taps that need to be opened.

Step-by-step Explanation
Initialization: We initialize end = 0, far_can_reach = 0, and cnt = 0.
Here, end represents the last point that can be watered by the previously considered taps,
far_can_reach is the farthest point that can be watered by any tap considered so far, and cnt keeps track of the number of taps opened.

Prepare the Ranges: We prepare an array arr where the index represents the starting point,
and the value at that index represents the farthest point that can be watered from that starting point.

Main Algorithm: We iterate through the array arr. If the current index i is greater than end, we update end to far_can_reach and increment cnt by 1.
This is because we need to open a new tap to extend our reach.

Check for Gaps: If at any point we find that we can't extend our reach (far_can_reach <= end), we return -1.

Count Taps: cnt keeps track of the minimum number of taps we need to open.

Wrap-up
The function returns the minimum number of taps needed to water the entire garden. If it's not possible to water the whole garden, the function returns -1.

Complexity Analysis
Time Complexity: The algorithm runs in O(n)O(n)O(n) time because it only needs to traverse the array arr once.

Space Complexity: The space complexity is O(n)O(n)O(n) due to the additional array arr.

 */

/*

Intuition and Logic Behind the Solution
The problem asks us to water the entire garden by opening the minimum number of taps. Unlike the greedy approach, which focuses on extending the range to be watered as far as possible, the dynamic programming approach calculates the minimum number of taps needed to water each point in the garden.

Why Dynamic Programming?
Dynamic programming (DP) is effective here because it allows us to build up a solution incrementally, using previously calculated results to inform future calculations. Each element in the DP array represents the minimum number of taps needed to water up to that point, which we update as we consider each tap in the garden. The DP approach is particularly useful when we need to make decisions that depend on previous choices, as is the case here.

Step-by-step Explanation
Initialization: Initialize an array dp of size n+1 with float('inf'), except for dp[0], which is set to 0. This array will store the minimum number of taps needed to water up to each point.
Iterate through Ranges: Loop through the array ranges, which contains the range each tap can cover.
Calculate Start and End: For each tap at index i, calculate the start and end of the interval it can water.
Update DP Array: For each point j in the interval, update dp[j] to be the minimum of its current value and dp[start]+1dp[\text{start}] + 1dp[start]+1.
Check Feasibility: If dp[-1] remains float('inf'), then the garden can't be fully watered, and the function returns -1.
Wrap-up
The function returns dp[-1], which holds the minimum number of taps needed to water the entire garden, or -1 if it's not possible to water the whole garden.

Complexity Analysis
Time Complexity: O(n2)O(n^2)O(n
2
 ) due to the nested loop structure. For each tap, we potentially update O(n)O(n)O(n) elements in the DP array.
Space Complexity: O(n)O(n)O(n) for storing the DP array.
This DP approach provides an exact solution but may be slower than the greedy approach for large problem sizes. However, it is conceptually straightforward and builds a solid foundation for understanding more complex DP problems.



 */

import java.util.Arrays;

public class Q1326_Minimum_Number_of_Taps_to_Open_to_Water_a_Garden {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);

        for(int i = 0; i < ranges.length; i++) {
            if(ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int end = 0, far_can_reach = 0, cnt = 0;
        for(int i = 0; i <= n; i++) {
            if(i > end) {
                if(far_can_reach <= end) return -1;
                end = far_can_reach;
                cnt++;
            }
            far_can_reach = Math.max(far_can_reach, arr[i]);
        }

        return cnt + (end < n ? 1 : 0);
    }
}
