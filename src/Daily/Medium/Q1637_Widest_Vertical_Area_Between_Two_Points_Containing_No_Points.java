package Daily.Medium;

/*
1637. Widest Vertical Area Between Two Points Containing No Points
Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.

A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height).
The widest vertical area is the one with the maximum width.

Note that points on the edge of a vertical area are not considered included in the area.



Example 1:
Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Explanation: Both the red and the blue area are optimal.


Example 2:

Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
Output: 3


 */

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {
    public static int maxWidthOfVerticalArea(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int n = points.length;
        int diff = 0;
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = points[i][0];
        }
        System.out.println(new Gson().toJson(arr));
        for (int i = 1; i < n; i++) {
            diff = Math.max(diff, arr[i] - arr[i-1]);
        }
        return diff;
    }
}
