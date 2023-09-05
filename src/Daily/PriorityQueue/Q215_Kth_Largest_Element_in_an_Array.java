package Daily.PriorityQueue;

/*

215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5


Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 */

import java.util.PriorityQueue;

public class Q215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res = queue.poll();
            k--;
            if (k == 0) {
                return res;
            }
        }
        return 0;
    }

    //using heap
    /*

        Complexity
        Time Complexity: O(nlog⁡k)O(n \log k)O(nlogk)
        Each of the n elements is processed once. However, heap operations take O(log⁡k)O(\log k)O(logk) time,
        leading to an overall complexity of O(nlog⁡k)O(n \log k)O(nlogk).

        Space Complexity: O(k)O(k)O(k)
        The solution uses a heap with a maximum of k elements.

     */
    public int findKthLargest_v2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
