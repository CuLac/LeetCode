package Daily.Medium;

/*

779. K-th Symbol in Grammar
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.



Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation:
row 1: 0
row 2: 01

 */

/*

==> chuỗi sinh ra luôn là chuỗi đối xứng giữa 0 và 1
the parent of kth index in nth row is
    - k/2 index in the n-1 row for even numbered indexes.
    - (k+1)/2 index in the n-1 row for odd numbered indexes

Also notice that the kth value of the index in nth row is:
    - flipped (reversed) value of the parent i.e. k/2 index in the n-1 row for even numbered indexes.
    - same value as for the parent i.e. the (k+1)/2 index in the n-1 row for odd numbered indexes.

 */

public class Q779_Kth_Symbol_in_Grammar {
    public static int kthGrammar(int n, int k) {
        if(n==1) {
            return 0;
        }
        int parent = kthGrammar(n-1, (k+1)/2);
        if(k%2 == 0) {
            return parent == 1? 0 : 1;
        } else {
            return parent;
        }
    }
}
