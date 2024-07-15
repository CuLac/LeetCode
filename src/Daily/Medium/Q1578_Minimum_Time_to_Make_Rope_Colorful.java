package Daily.Medium;

/*
1578. Minimum Time to Make Rope Colorful

Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help.
Bob can remove some balloons from the rope to make it colorful.
You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.



Example 1:

Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.


Example 2:

Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.


Example 3:

Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1578_Minimum_Time_to_Make_Rope_Colorful {

    //using priority queue
    public static int minCost(String colors, int[] neededTime) {
        if (colors.length() < 2) {
            return 0;
        }
        char [] arr = colors.toCharArray();
        int n = arr.length;
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        queue.add(neededTime[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                queue.add(neededTime[i]);
            } else {
                while (queue.size() > 1) {
                    res += queue.poll();
                }
                queue.clear();
                queue.add(neededTime[i]);
            }
        }
        while (queue.size() > 1) {
            res += queue.poll();
        }
        return res;
    }


    public int minCost_v2(String colors, int[] neededTime) {
        if (colors.length() < 2) {
            return 0;
        }
        char [] arr = colors.toCharArray();
        int n = arr.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                res += Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]); //gia tri be hon da bị remove
            }
        }
        return res;
    }
}
