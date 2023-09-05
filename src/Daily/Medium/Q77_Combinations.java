package Daily.Medium;

/*

77. Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

 */

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Q77_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int [] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }
        int [] data = new int[n];
        combinationUtil(arr, data, 0, n-1, 0, k, res);
        return res;
    }

    private static void combinationUtil(int arr[], int data[], int start, int end, int index, int k, List<List<Integer>> res) {
        if (index == k) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<k; j++) {
                temp.add(data[j]);
            }
            res.add(temp);
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= k-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data,i+1, end, index+1, k, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(combine(4, 2)));
    }
}
