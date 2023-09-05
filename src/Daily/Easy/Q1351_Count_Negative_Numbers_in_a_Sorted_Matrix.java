package Daily.Easy;

/*

1351. Count Negative Numbers in a Sorted Matrix
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.



Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0

 */

public class Q1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
    public int countNegatives(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 0) {
                    count += m - j;
                    break;
                }
            }
        }
        return count;
    }
}
