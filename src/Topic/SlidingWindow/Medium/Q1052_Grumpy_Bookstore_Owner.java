package Topic.SlidingWindow.Medium;

/*
1052. Grumpy Bookstore Owner
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
You are given an integer array customers of length n where customers[i] is the number of the customer that enters
the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1
if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes,
but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.



Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.


Example 2:

Input: customers = [1], grumpy = [0], minutes = 1
Output: 1

 */

public class Q1052_Grumpy_Bookstore_Owner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        if (customers.length == 0) {
            return 0;
        }

        if (grumpy.length == 0) {
            return 0;
        }

        int n = customers.length;
        int res = 0;
        if (n < minutes) {
            for (int cus : customers) {
                res += cus;
            }
            return res;
        }

        //number customer satisfied origin
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }

        int diff = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = 0;
            if (grumpy[i] == 1) {
                int left = i;
                while (left < n && left < minutes + i) {
                    if (grumpy[left] == 1) {
                        curr += customers[left];
                    }
                    left++;
                }
            }
            System.out.println("Curr=" + curr);
            diff = Math.max(diff, curr);
        }
        return res + diff;
    }

    public int maxSatisfied_v2(int[] customers, int[] grumpy, int minutes) {
        int sum =0;

        for (int i = 0; i <customers.length; i++) {
            sum = sum + customers[i] * (1-grumpy[i]);
            grumpy[i] = customers[i] * grumpy[i]; //synchronize 2 array --> 1 array --> simple sliding window to find subarray(length k = minutes) with max value
        }

        //find max value of subarray with length k = minutes from array grumpy
        int max = 0;

        //create origin value
        for (int i =0; i < minutes; i++) {
            max += grumpy[i];
        }

        int save = max;

        //start scan window
        for (int i = minutes; i < customers.length; i++) {
            save = save + grumpy[i] - grumpy[i-minutes];
            max = Math.max(save, max);
        }
        return sum + max;
    }
}
