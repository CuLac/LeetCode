package Daily.BinarySearch;

/*

2141. Maximum Running Time of N Computers
You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run
a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given batteries.

Initially, you can insert at most one battery into each computer. After that and at any integer time moment,
you can remove a battery from a computer and insert another battery any number of times.
The inserted battery can be a totally new battery or a battery from another computer.
You may assume that the removing and inserting processes take no time.

Note that the batteries cannot be recharged.

Return the maximum number of minutes you can run all the n computers simultaneously.

Example 1:


Input: n = 2, batteries = [3,3,3]
Output: 4
Explanation:
Initially, insert battery 0 into the first computer and battery 1 into the second computer.
After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1 can still run for one minute.
At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert battery 1 instead.
By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
We can run the two computers simultaneously for at most 4 minutes, so we return 4.

Example 2:


Input: n = 2, batteries = [1,1,1,1]
Output: 2
Explanation:
Initially, insert battery 0 into the first computer and battery 2 into the second computer.
After one minute, battery 0 and battery 2 are drained so you need to remove them and insert battery 1 into the first
computer and battery 3 into the second computer.
After another minute, battery 1 and battery 3 are also drained so the first and second computers are no longer running.
We can run the two computers simultaneously for at most 2 minutes, so we return 2.


Observations
If the computers cannot run simultaneously for a minutes, then definitely they cannot run simultaneously for b > a minutes.
During a simultaneous run of a minutes, each battery, no matter how long it can run, can "contribute" a maximum of a minutes to the total running time.



Solution
Based on Observation #1, perform a Binary Search on the maximum number of minutes for the simultaneous run attainable.
The lower and upper bound for the Binary Search are 0 (cannot run at all) and sum(batteries[i]) / n (the computers' total
running time cannot exceed total battery amounts)
During each search, check whether all batteries "contribute" enough for the total running time required for this simultaneous run, based on Observation #2.
The running time would be O(n lg m) where m = sum(batteries[i]) and n = batteries.length are the total sum of all batteries, and number of batteries.

 */

public class Q2141_Maximum_Running_Time_of_N_Computers {
    public static long maxRunTime(int n, int[] batteries) {
        int sum = 0;
        for (int bat : batteries) {
            sum += bat;
        }
        int left = 0;
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canFit(batteries, n, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static boolean canFit(int[] batteries, int n, int k) {
        int sum = 0;
        //so luong pin tieu thu trong truong hop moi may tinh su dung k pin
        int target = n*k;
        for (int bat : batteries) {
            if (bat < k) {
                sum += bat;
            } else {
                sum += k;
            }
        }
        return sum >= target;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,1};
        System.out.println(maxRunTime(2, arr));
    }
}
