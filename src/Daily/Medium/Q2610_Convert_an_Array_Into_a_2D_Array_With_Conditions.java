package Daily.Medium;

/*
2610. Convert an Array Into a 2D Array With Conditions
You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.



Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.


Example 2:

Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.

 */

import com.google.gson.Gson;

import java.util.*;

public class Q2610_Convert_an_Array_Into_a_2D_Array_With_Conditions {
    public static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(new Gson().toJson(map));
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int count = 0;
        while (count < n) {
            List<Integer> list = new ArrayList<>();
            count = addArray(map, res, count);
            System.out.println(count);
        }
        return res;
    }

    public static int addArray(HashMap<Integer, Integer> map, List<List<Integer>> res, int count) {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() > 0) {
                list.add(entrySet.getKey());
                map.put(entrySet.getKey(), entrySet.getValue() - 1);
            }
        }
        count += list.size();
        res.add(list);
        return count;
    }

    public List<List<Integer>> findMatrix_V2(int[] nums) {
        int[] freq = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
