package Daily.Medium;

/*

287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2


Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q287_Find_the_Duplicate_Number {
    /*
        Brute Force (2 Loops)
        Time Complexity: O(n^2)
        Space Complexity: O(1)
     */

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }

    /*
        Using a HashSet\texttt{HashSet}HashSet to record the occurrence of each number.
        With extra O(n)O(n)O(n) space, without modifying the input.
        Time Complexity: O(n)
        Space Complexity: O(n)

     */

    public static int findDuplicate_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return len;
    }

    /*
        using Arrays
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static int findDuplicate_mark(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                //số nào nhỏ hơn 0 ==> số bị lặp lại
                return idx;
            }
            nums[idx] = -nums[idx];   //chuyen các số trong mảng numb ban đàu thành số âm
        }

        return len;
    }

    /*

        Sort Array
        --> 2 số cạnh nhau bằng nhau --> số duplicate
        Time Complexity: O(nlogn)
        Space Complexity: O(logn)
     */

    public static int findDuplicate_sort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return len;
    }

    /*
        Binary Search
        Do có 1 phần tử duplicate nên khi ta chia mảng thành 2 phần luôn có 1 phần có số phần tử lớn hơn
        --> phần tử duplicate sẽ nằm trong nửa này

        Time Complexity: O(nlogn)
        Space Complexity: O(1)
     */
    public static int findDuplicate_bs(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;  //bien dem so luong phan tu o 1 ben khi chia doi mảng
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {   //phần tử duplicate nằm ở phần [mid, high]
                low = mid + 1;
            } else {    //phần tử duplicate nằm ở phần [left, mid]
                high = mid;
            }
        }

        return low;
    }

    /*
        Sử dụng bit
        Time Complexity: O(nlogn)
        Space Complexity: O(1)
     */

    public static int findDuplicate_bit(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }

        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }

        return ans;
    }

    /*
        Sử dụng thuật toán Floyd's Toitorse and Hare
        Time Complexity: O(nlogn)
        Space Complexity: O(1)

     */

    public int findDuplicate_fastSlow(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
