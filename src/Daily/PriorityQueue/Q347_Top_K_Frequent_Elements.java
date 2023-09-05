package Daily.PriorityQueue;

/*

347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

 */

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q347_Top_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        System.out.println(new Gson().toJson(map));
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> val : map.entrySet()) {
            queue.add(val);
        }
        System.out.println(new Gson().toJson(queue));
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            Map.Entry<Integer, Integer> val = queue.poll();
            System.out.println(new Gson().toJson(val));
            res[i] = val.getKey();
            i++;
        }
        return res;
    }
}
