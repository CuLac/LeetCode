package Daily.Medium;

/*

54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]



Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */

import java.util.ArrayList;
import java.util.List;

public class Q54_Spiral_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) {
            return list;
        }
        int m = matrix[0].length;
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top < bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left < right) {
                for (int i = bottom; i >= top;i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
