package Question_Interview.Arrays_String.Easy;

/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 */

import java.util.Arrays;

public class Q169_Majority_Element {

    // sap xep mang theo thu tu tang dan
    // Gia tri chiem da so (chiem hon n/2) ==> vi tri giua mang luon luon la gia tri can tim
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /*

    Cach 2:
    - Su dung thuạt toan Boyer-Moore Majority Voting Algorithm:
    - Giam thieu tai nguyen do viec sap xep mang gay ra
    - Duyet tu dau mang den cuoi mang
    - Lay vi tri dau tien lam gia tri can tim => count = 1
    - Voi cac gia tri giong gia tri ban dau => count + 1, nguoc lai count - 1
    - Neu count = 0 va gia tri tai vi tri [i] khac majority => gan gia tri nums[i] = majority va count = 1


     */

    public int majorityElement_v2(int[] nums) {
        // Initialize variables to keep track of the majority element and its occurrence count.
        int count = 0;
        int majority = 0;

        // Loop through the array to find the majority element using Boyer-Moore Majority Vote Algorithm.
        for (int i = 0; i < nums.length; i++) {

            // If the count is 0 and the current majority candidate is not equal to the current element,
            // update the majority candidate to the current element and set count to 1.
            if (count == 0 && majority != nums[i]) {
                majority = nums[i];
                count = 1;
            } else if (majority == nums[i]) {
                // If the current element is equal to the majority candidate, increment the count.
                count++;
            } else {
                // If the current element is not equal to the majority candidate, decrement the count.
                count--;
            }
        }

        // The majority variable will contain the element that appears more than ⌊n/2⌋ times in the array.
        return majority;
    }
}
