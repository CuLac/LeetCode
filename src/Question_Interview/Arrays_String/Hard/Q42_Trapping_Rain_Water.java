package Question_Interview.Arrays_String.Hard;

/*

42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.



Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

 */

public class Q42_Trapping_Rain_Water {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int l=0,r=height.length-1,lmax=0,rmax=0,water=0;
        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            water+=(lmax<rmax)? lmax-height[l++]:rmax-height[r--];
        }
        return water;
    }

    public int trap_v2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int lmax = height[0];
        int rmax = height[height.length - 1];
        int water = 0;
        while (left < right) {
            if (lmax < rmax) {
                left++;
                if (lmax < height[left]) {
                    lmax = height[left];
                } else {
                    water += lmax - height[left];
                }
            } else {
                right--;
                if (rmax < height[right]) {
                    rmax = height[right];
                } else {
                    water += rmax - height[right];
                }
            }
        }
        return water;
    }
}
