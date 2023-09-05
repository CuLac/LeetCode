package Daily.DynamicProgramming;

/*

1035. Uncrossed Lines
You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

nums1[i] == nums2[j], and
the line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).

Return the maximum number of connecting lines we can draw in this way.



Example 1:
Input: nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.



Example 2:
Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
Output: 3



Example 3:

Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
Output: 2

 */

public class Q1035_Uncrossed_Lines {
    /*
        Approach:
            The problem can be solved using dynamic programming. We can define a two-dimensional array dp, where dp[i][j] represents
            the maximum number of uncrossed lines between the first i elements of nums1 and the first j elements of nums2.
            The base case is dp[0][j] = 0 and dp[i][0] = 0, since there are no elements in either array.

            For each element nums1[i-1] in nums1 and each element nums2[j-1] in nums2, we can either include or exclude the current element.
            If nums1[i-1] is equal to nums2[j-1], then we can include it in the uncrossed lines, and the maximum number of uncrossed lines is dp[i-1][j-1] + 1.
            Otherwise, we can exclude it, and the maximum number of uncrossed lines is the maximum of dp[i-1][j] and dp[i][j-1].

            The final answer is dp[m][n], where m and n are the lengths of nums1 and nums2 respectively.

        Intuition:
            The problem asks us to find the maximum number of uncrossed lines between two arrays.
            We can think of the elements in nums1 and nums2 as points on two parallel lines, and the uncrossed lines as line segments connecting these points.
            If two points have the same value, then we can draw a line segment between them, indicating that they are uncrossed.
            The goal is to find the maximum number of such line segments.

            To find the maximum number of uncrossed lines, we can use dynamic programming.
            We can start with the base case of zero elements, and then gradually build up the solution by adding elements one by one.
            At each step, we consider whether to include or exclude the current element, and update the maximum number of uncrossed lines accordingly.

            By considering all possible combinations of elements from both arrays, we can find the maximum number of uncrossed lines between the two arrays.
            The dynamic programming approach allows us to avoid redundant calculations and find the optimal solution efficiently.
    */
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int curr = dp[j];
                if (nums1[i-1] == nums2[j-1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j-1], curr);
                }
                prev = curr;
            }
        }
        return dp[n];
    }
}
