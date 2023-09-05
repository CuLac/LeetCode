package Question_Interview.Two_Pointer.Medium;

/*

11. Container With Most Water
You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1

 */

public class Q11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height.length <= 0) {
            return 0;
        }
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        while (left < right) {
            int lmax = height[left];
            int rmax = height[right];
            res = Math.max(res, Math.min(lmax, rmax) * (right - left));
            if (lmax > rmax) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
