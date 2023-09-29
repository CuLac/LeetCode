package Topic.TwoPointer;

/*

18. 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

 */

import com.google.gson.Gson;

import java.util.*;

public class Q18_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int j = i+1;
                int k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < target) {
                        int diff = target - sum;
                        if (set.contains(diff) && nums[j] <= diff && diff <= nums[k]) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(diff);
                            res.add(list);
                            while (nums[j] == nums[j+1] && j+2 < k) {
                                j++;
                            }
                            while (nums[k] == nums[k-1] && j< k - 2) {
                                k--;
                            }
                            j++;
                            k--;
                        } else {
                            j++;
                        }
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(new Gson().toJson(fourSum(arr, target)));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mảng: ");
        if (scanner.hasNextLine()) {
            String str = scanner.next();
            System.out.println(str);
        }
    }
}
