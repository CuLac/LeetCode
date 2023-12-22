package Daily.Easy;

/*
1287. Element Appearing More Than 25% In Sorted Array
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.



Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Example 2:

Input: arr = [1,1]
Output: 1

 */

public class Q1287_Element_Appearing_More_Than_25_In_Sorted_Array {
    /*
        The time complexity of this approach would be O(3 * log(n)) (finding lower bound would O(log(n)) each and repeating same for 3 elements)
        and the space complexity would be O(1).
     */

    public int bin_find1(int arr[], int val) {
        // to find the lower bound
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] >= val) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
    public boolean valid(int arr[], int ind) {
        int n = arr.length;
        int start = bin_find1(arr, arr[ind]);
        if(arr[start + (n / 4)] == arr[ind]) return true;
        return false;
    }
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int first = n / 4;
        int second = n / 2;
        int third = 3 * n / 4;

        if(valid(arr, first)) return arr[first];
        else if(valid(arr, second)) return arr[second];
        else if(valid(arr, third)) return arr[third];
        return -1;
    }
}
