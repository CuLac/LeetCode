package Daily.BinarySearch;

/*

74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 */

public class Q74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int col = matrix.length - 1, row = matrix[0].length - 1;
        int low = 0;
        int high = col;
        while (low <= high) {
            if (matrix[high][0] <= target) {
                low = high;
                break;
            }
            int mid = (low + high) / 2;
            if (matrix[mid][0] <= target && matrix[mid][row] >= target) {
                low = mid;
                break;
            }
            if (matrix[mid][0] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            }
        }
        int start = 0;
        int end = row;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[low][mid] == target) {
                return true;
            } else if (matrix[low][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
