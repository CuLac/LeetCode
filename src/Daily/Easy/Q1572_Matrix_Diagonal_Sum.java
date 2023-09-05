package Daily.Easy;

/*

1572. Matrix Diagonal Sum
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

 */

public class Q1572_Matrix_Diagonal_Sum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        if (n <= 0) {
            return 0;
        }
        int m = mat[0].length;
        int i = 0;
        int j = m - 1;
        int res = 0;
        while (i < n && j >= 0) {
            if (i != j) {
                res = res + mat[i][i] + mat[i][j];
            } else {
                res += mat[i][i];
            }
            i++;
            j--;
        }
        return res;
    }
}
