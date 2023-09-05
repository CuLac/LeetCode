package Daily.Medium;

/*

59. Spiral Matrix II
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]



Example 2:
Input: n = 1
Output: [[1]]

 */

public class Q59_Spiral_Matrix_II {
    public static int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int index = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = index;
                index++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = index;
                index++;
            }
            right--;
            if (top < bottom) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = index;
                    index++;
                }
                bottom--;
            }
            if (left < right) {
                for (int i = bottom; i >= top;i--) {
                    res[i][left] = index;
                    index++;
                }
                left++;
            }
        }
        return res;
    }
}
