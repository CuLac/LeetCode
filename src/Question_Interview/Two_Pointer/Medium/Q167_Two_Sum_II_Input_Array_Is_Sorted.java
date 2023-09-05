package Question_Interview.Two_Pointer.Medium;

/*

167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].



Solution:

- Do mảng là 1 dãy số k giảm nên có thể sử dụng 2 con trỏ để tìm kiếm cặp số cần tìm
- Đặt 1 con trỏ ở đầu và 1 con trỏ ở cuối (giá trị nhỏ nhất và giá trị lớn nhất)

---> tổng 2 số > target   --> giảm giá trị lớn
---> tổng 2 số < target   --> tăng giá trị nhỏ

 */

public class Q167_Two_Sum_II_Input_Array_Is_Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        if (numbers.length < 2) {
            return res;
        }
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                res[0] = low + 1;
                res[1] = high + 1;
                return res;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }
}
