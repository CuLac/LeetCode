package Daily.SlidingWindow;

/*

239. Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.


Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


Example 2:

Input: nums = [1], k = 1
Output: [1]


 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q239_Sliding_Window_Maximum {

    //basic solution --> O(n*k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int numOfWindow = n - k + 1;
        int[] result = new int[numOfWindow]; // number of windows

        for (int start = 0; start < numOfWindow; ++start) {
            int end = start + k - 1;
            int maxVal = nums[start];
            for (int i = start + 1; i <= end; ++i) {
                if (nums[i] > maxVal) { // update
                    maxVal = nums[i];
                }
            }
            result[start] = maxVal;
        }

        return result;

    }

    //advantage solution(use priority queue)
    public int[] maxSlidingWindow_v2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> nums[i2]-nums[i1]);
        int n= nums.length;
        int[] output = new int[n-k+1];
        int outputIndex = 0;
        for(int i=0; i<nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()<i-k+1) { // remove out of bound indices from root
                pq.remove();
            }
            pq.add(i); // add current element index to pq; this either goes to root or root remains unchanged

            if(i-k+1>=0) {
                output[outputIndex++] = nums[pq.peek()];
            }
        }

        return output;
    }

    //best solution
    public int[] maxSlidingWindow_v3(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }
}
