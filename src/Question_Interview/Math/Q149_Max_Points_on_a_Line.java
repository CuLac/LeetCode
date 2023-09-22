package Question_Interview.Math;

/*

149. Max Points on a Line
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.



Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

 */

/*
 *  A line is determined by two factors,say y=ax+b
 *
 *  If two points(x1,y1) (x2,y2) are on the same line(Of course).

 *  Consider the gap between two points.

 *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

 *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

 *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

 *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

 *  So we can use y0&x0 to track a line;
 */


/*

Approach and Explantation
It does this by iterating through every combination of two points (i and j) in the input array of points and then checks every other point (k) to see if it is collinear with i and j.

To determine if three points are collinear, the code calculates the slope between point i and point j, and then compares it to the slope between point i and point k. If the slopes are equal, then the three points are collinear.

The slope between two points (x1, y1) and (x2, y2) is calculated as (y2 - y1) / (x2 - x1).Let suppose we have three points (x1, y1),(x2, y2) and (x3, y3) and compare the two slopes then expression is written in this formet(y2 - y1) * (x3 - x1) = (y3 - y1) * (x2 - x1) similarly In this code, this calculation is broken down into two separate parts: (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]) and (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]). The reason for this is to avoid a division by zero error in cases where the two points have the same x-coordinate.

If the code determines that three points i, j, and k are collinear, it increments a temporary count variable temp. After checking every point k, the code compares temp to the current maximum number of collinear points found so far, ans, and updates ans if temp is larger.

Finally, the code returns the maximum number of collinear points, ans.

 */


public class
Q149_Max_Points_on_a_Line {
    public int maxPoints(int[][] points) {
        // n is the number of points in the array
        int n = points.length;

        // If there are 0 or 1 points, there is at most one line that can be formed
        // (i.e., the line formed by the single point, or no line if there are no points)
        if(n <= 2) return n;

        // Initialize the maximum number of points on a line to 2, since there must be at least 2 points to form a line
        int ans = 2;

        // Iterate through all pairs of points
        for(int i = 0 ;i < n; i++){
            for(int j = i+1; j < n ; j++){
                // temp is the number of points on the line formed by point i and point j
                int temp = 2;
                // Check if any other points are on the same line as point i and point j
                for(int k = j+1 ; k<n ; k++ ){
                    // Check if point k is on the same line as point i and point j
                    // This is done by checking if the slope between point i and point k is equal to the slope between point i and point j
                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
                    if(x == y){
                        // If the slopes are equal, point k is on the same line as point i and point j
                        temp++;
                    }
                }
                // Update the maximum number of points on a line if necessary
                if(temp > ans){
                    ans = temp;
                }
            }
        }
        // Return the maximum number of points on a line
        return ans;
    }
}
