package Daily.Easy;

/*

1337. The K Weakest Rows in a Matrix
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.



Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].




Example 2:

Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].

 */

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1337_The_K_Weakest_Rows_in_a_Matrix {
    public static int[] kWeakestRows(int[][] mat, int k) {
        if (mat.length == 0) {
            return new int[0];
        }
        int n = mat.length;
        int m = mat[0].length;
        int [] res = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < n; i++) {
            int sodier = getNumbSodier(mat[i]);
            queue.offer(new int[]{sodier, i});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        System.out.println(new Gson().toJson(queue));
        for (int i = k - 1; i >= 0;i--) {
            res[i] = queue.poll()[1];
        }
        System.out.println(new Gson().toJson(res));
        return res;
    }

    private static int getNumbSodier(int [] row) {
        int n = row.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (row[mid] == 0) {
                r = mid - 1;
            } else
                l = mid + 1;
        }
        System.out.println("Result=" + l);
        return l;
    }
}
