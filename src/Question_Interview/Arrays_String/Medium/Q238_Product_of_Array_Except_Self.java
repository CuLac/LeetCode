package Question_Interview.Arrays_String.Medium;

/*

238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */

/*

Solution:
Mảng cần tìm là danh sách các tích các số trong mảng ngoại trừ vị trí i
Tích các số trong mảng tại vị trí gồm: tích các số đứng trước i * tích các số sau đứng trước i


=> tạo ra 2 mảng luu danh sách các tích số đứng trước i và tích các số đứng sau i

=> tích các số tại vị trí i

 */

import com.google.gson.Gson;

import java.util.Arrays;

public class Q238_Product_of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        //khoi tao tất cả các giá trị trong mảng ans = 1
        Arrays.fill(ans, 1);
        // tạo biến hứng giá trị tại vị trí i
        int curr = 1;

        //tính tích các số đứng trước i
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        System.out.println(new Gson().toJson(ans));
        //tra lại gia tri curr = 1 để tiếp tục tính tích các số đứng sau i
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        System.out.println(new Gson().toJson(ans));
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        productExceptSelf(arr);
    }
}
