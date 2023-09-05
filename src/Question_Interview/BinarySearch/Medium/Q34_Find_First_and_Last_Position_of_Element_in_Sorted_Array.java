package Question_Interview.BinarySearch.Medium;

/*

34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]



Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]



Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 */

import com.google.gson.Gson;

public class Q34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    // Solution 1
    /*
        Tìm lần lượt đầu cuối
     */

    private static int[] firstGreaterEqual(int[] nums, int target) {
        int [] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private static int findFirst(int [] nums, int target) {
        int idx = -1;
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else
                h = mid - 1;
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }

    private static int findLast(int [] nums, int target) {
        int idx = -1;
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] > target) {
                h = mid - 1;
            } else
                l = mid + 1;
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }


    //Solution 2
    private static int firstGreaterEqual_v2(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int[] searchRange(int[] A, int target) {
        int start = firstGreaterEqual_v2(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual_v2(A, target + 1) - 1};  //tang target thêm 1 đơn vị --> giá trị thu được là vị trí đầu tiên của cạnh giá trị cuối cùng của target(nên cần -1 khi trả về kết quả)
    }

    public static void main(String[] args) {
        int [] arr = {5,7,7,8,8,10};
        System.out.println(new Gson().toJson(firstGreaterEqual(arr, 8)));
    }
}
