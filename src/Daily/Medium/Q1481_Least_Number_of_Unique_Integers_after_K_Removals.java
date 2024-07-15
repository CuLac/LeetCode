package Daily.Medium;

/*
1481. Least Number of Unique Integers after K Removals
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.



Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

 */

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1481_Least_Number_of_Unique_Integers_after_K_Removals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        queue.addAll(map.entrySet());
        while (k > 0) {
            Map.Entry<Integer, Integer> entrySet = queue.peek();
            int val = entrySet.getValue();
            if (k >= val) {
                k -= val;
                queue.poll();
            } else {
                break;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int [] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }
}
