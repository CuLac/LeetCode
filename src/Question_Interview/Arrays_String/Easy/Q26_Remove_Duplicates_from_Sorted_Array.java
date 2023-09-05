package Question_Interview.Arrays_String.Easy;

/*

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

- Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
- Return k.

*/

public class Q26_Remove_Duplicates_from_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int nextPos = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start]) {
                nums[nextPos] = nums[i];
                start = nextPos;
                nextPos++;
            }
        }
        return nextPos;
    }

    public static int removeDuplicates_v2(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3};
        System.out.println(removeDuplicates_v2(arr));
    }
}
