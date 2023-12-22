package Daily.Hard;

/*

2009. Minimum Number of Operations to Make Array Continuous
You are given an integer array nums. In one operation, you can replace any element in nums with any integer.

nums is considered continuous if both of the following conditions are fulfilled:

All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

Return the minimum number of operations to make nums continuous.



Example 1:

Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.
Example 2:

Input: nums = [1,2,3,5,6]
Output: 1
Explanation: One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.
Example 3:

Input: nums = [1,10,100,1000]
Output: 3
Explanation: One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.

 */

/*

Solution:🚀
    1. Sort the nums array in ascending order to ensure that the elements are in increasing order.
    2. Create a set from the sorted nums array to remove duplicates. This step ensures that all elements are unique.
    3. Initialize a variable ans with a large value to store the minimum number of operations required to make the array continuous.
        You can use sys.maxsize for this purpose.
    4. Iterate through the unique elements of the sorted nums array. For each element s in the iteration:
        Calculate the expected end element e of a continuous subarray. This is done by adding n - 1 to the current element s,
        where n is the length of the input array nums. This step ensures that the difference between the maximum and minimum
        elements in the continuous subarray is n - 1.
        Use the bisect_right function to find the index idx where the expected end element e would be inserted into the sorted nums array
        while maintaining its order. This index represents the position where the end element of the continuous subarray would be inserted if it exists in nums.
        Update the ans variable with the minimum number of operations needed to make the array continuous.
        This minimum is calculated as n - (idx - i), where idx is the position of the expected end element,
        and i is the current position of the start element.
    5. Finally, return the minimum number of operations stored in the ans variable.

 */

/*

Insights used to solve the problem:
    Sorting the array and removing duplicates by creating a set helps in ensuring that all elements are unique and in ascending order,
    which simplifies the calculation of the expected end element.
    The key insight is that for an array to be continuous, the difference between the maximum and minimum elements should be equal to n - 1,
    where n is the length of the array. Therefore, you can calculate the expected end element based on the start element
    and find its position in the sorted array to determine the minimum number of operations needed.
    Using the bisect_right function is an efficient way to find the index where the expected end element would be inserted,
    as it takes advantage of the sorted nature of the array.
    Keeping track of the minimum number of operations (ans) during the iteration and updating it whenever a more optimal
    solution is found ensures that you find the minimum operations overall.

 */

import java.util.Arrays;

public class Q2009_Minimum_Number_of_Operations_to_Make_Array_Continuous {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count=Integer.MAX_VALUE,j=1,dup=0;
        int[] dupArr = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            while(j<nums.length&&nums[j]<=nums[i]+nums.length-1) {
                if(nums[j]==nums[j-1]) ++dup;
                dupArr[j]=dup;
                j++;
            }
            count = Math.min(count, i+(nums.length-j)+dup-dupArr[i]);
        }
        return count;
    }
}
