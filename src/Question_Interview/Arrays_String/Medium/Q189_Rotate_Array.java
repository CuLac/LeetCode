package Question_Interview.Arrays_String.Medium;

/*

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 */

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length == 0) {
            return;
        }

        int n = nums.length;
        int [] res = new int[n];
        while (k > 0) {
            int temp = nums[n-1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void rotate_v2(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length == 0) {
            return;
        }

        int n = nums.length;
        if (k % n == 0) {
            return;
        } else {
            k = k % n;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < k) {
            stack.add(nums[n - i - 1]);
            i++;
        }
        i = n - k - 1;

        while (i >= 0) {
            System.out.println(i + "|" + nums[i]);
            nums[i + k] = nums[i];
            i--;
        }
        i = 0;
        while (!stack.isEmpty()) {
            nums[i] = stack.pop();
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate_v2(nums, 1);
        System.out.println(new Gson().toJson(nums));
    }
}
