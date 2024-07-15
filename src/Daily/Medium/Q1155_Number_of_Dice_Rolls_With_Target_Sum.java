package Daily.Medium;

/*
1155. Number of Dice Rolls With Target Sum
You have n dice, and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice,
so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.



Example 1:

Input: n = 1, k = 6, target = 3
Output: 1
Explanation: You throw one die with 6 faces.
There is only one way to get a sum of 3.
Example 2:

Input: n = 2, k = 6, target = 7
Output: 6
Explanation: You throw two dice, each with 6 faces.
There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: n = 30, k = 30, target = 500
Output: 222616187
Explanation: The answer must be returned modulo 10^9 + 7.

*/

/*
HOW TO IDENTIFY IF THIS PROBLEM IS A DYNAMIC PROGRAMMING PROBLEM?

Suppose we have 3 dices with 6 sides each and we need target sum of 9. We throw the dices.
3 dices can have these combinations: 1+4+4, 1+2+6, 1+3+5, 1+6+2...etc.

We notice that for dice number 1, if we fix value as 1, we can then solve the problem for dice 2 and 3 for a target sum of 8.
Similarly, if we fix 2 for dice 2, we can solve rest of two dices for target sum of 7. Similarly for 3 and so on.

So, basically we have a choice and making these choices take us in different directions - like a tree.
Also, we see that if we fix dice 1, we can reduce our problem for just 2 dices!
Whenever we have a problem where we have choices and if these choices lead to reduction of a larger problem into smaller sub-problems,
the problem can be solved with dynamic programming (DP).

The best way, I believe, to solve a DP problem is by writing a recursive solution and then optimising it.

 */

/*
APPROACHING THIS PROBLEM

We have seen that we can reduce our problem into smaller problems by fixing a dice's value and then solving for remaining dices for remaining target sum.
So, if we fix dice 1 to value 1, we have a smaller problem to solve where dices are 2 and target sum is 8.

This continuous reduction ultimately will reduce to solving a problem where we have just one dice left and one target sum
to achieve and if we invoke our solve function on this, we get to base case.

Recursive functions work on faith, base condition and some small logic that we need to write for the faith to work.

So, we can say from our discussion that we can have faith in our function that if we call the same function for a smaller input,
it'll give me the correct answer.

From our discussion above, we see that the reducing factors in problem are the target sum and the number of dices.

So, if we solve f(number of dices, target sum) we can have faith that our f(number of dices - 1, target sum - dice_value)
will give us the correct result for the sub-problem solving for n - 1 dices and target sum - dice_value.

--> So we can write:
    private int numRollsToTarget(int n, int k, int target) {
        //recursive function call on smaller input
        numRollsToTarget(n - 1, k, target - dice_value); //have faith that this would give us the right result for the sub problem.
    }

Coming to base condition:

The base condition can be derived from thinking of the smallest possible value for our function. So, if we have 0 number of dices and target sum asked is 0, then we don't even need to throw dices. There is 1 way. This is our base condition.

--> So, our base condition can be written as:

    if (target == 0 && n == 0)
  	    return 1;

Now, say the recursive function gives us the correct value for the sub-problem.
Initially count is 0. So, we can add the sub-problem's solution to our count.
--> This can be written as:
    private int numRollsToTarget(int n, int k, int target) {
        if (target == 0 && n == 0)
            return 1;
        count = 0;	//initial count
        //recursive function call on smaller input
        int subCount = numRollsToTarget(n - 1, k, target - dice_value); //have faith that this would give us the right result for the sub problem.
        count = count + subCount;	//add the sub-problem count to the bigger problem count.
    }

But note that our dices have k faces. So, when we do target - dice_value, we need to check for counts for all combinations. This way:

        total count if we set k = 1
        total count if we set k = 2
        total count if we set k = 3
        total count if we set k = 4
        .
        .
        .
        total count if we set k = k

So, our recursive function needs to be in an iteration from 1 to k.

The last thing that we need to think about in extension to our base condition is - what if we hit our base case but the target is not yet zero?
That's not a solution. Also, what if we make target -ve by setting wrong value?
(For exapmple, to get 11 from 2 dices, if we fix 1st dice to 6, our recursive code will at some point in iteration send 11-6-6 = -1 as target.
So, 6,6 cannot be counted as a solution.

When these conditions are met, we need not count these as a solution. So, if these are true, we can return count as 0:

    if (target < 0 || n == 0)
        return 0;


 */

import java.util.Arrays;

public class Q1155_Number_of_Dice_Rolls_With_Target_Sum {
    private int mod = (int) Math.pow(10, 9) + 7;	//mod initialisation

    // Use recursive

    /*
        --> PROBLEM:
        - The above solution works pretty well for smaller cases. But we hit TLE for larger testcases. Let's memoize this recursive solution now.
        - The cache which we initialise is always based on parameters which are changing in recursive calls.
            We have target and n changing every time in recursive call. So, we would make a 2-D cache array of size (n + 1) * (target + 1).
            And before making recursive call, we will check if the subproblem has already been solved for that n and target.
            If yes, we will return the value stored in cache and will not enter the rabbithole of recursion.
            Everything remains same except the cache.

     */
    public int numRollsToTarget(int n, int k, int target) {
        if (target == 0 && n == 0)	//if we hit a valid case, return 1
            return 1;
        if (target < 0 || n == 0)	//if we hit an invalid case, return count as 0
            return 0;
        int count = 0;	//initial count set to zero
        for (int i = 1; i <= k; i++) {	//iteration because we have dices face value from 1 to k.
            count = (count + numRollsToTarget(n - 1, k, target - i) % mod) % mod;	//magic function based on faith. mod is as per question.
        }
        return count;	//return count.
    }

    // Use dynamic programing
    public int numRollsToTarget_v2(int n, int k, int target) {
        int [][] dp = new int[n + 1][target+1];
        for (int [] a: dp) {
            Arrays.fill(a, -1);	//fill all values in the 2-D matrix with -1 because count cannot be -1.
        }
        return numRollsToTarget(n, k, target, dp);
    }

    private int numRollsToTarget(int n, int k, int target, int[][] mem) {
        if (target == 0 && n == 0)
            return 1;
        if (target < 0 || n == 0)
            return 0;
        if (mem[n][target] != -1)
            return mem[n][target];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = (count + numRollsToTarget(n - 1, k, target - i, mem) % mod) % mod;
        }
        return mem[n][target] = count;
    }

    // using backtrack
    private int numRollsToTarget_Backtrack(int n, int k, int target, int[][] mem) {
        if (target == 0 && n == 0)
            return 1;
        if (target < 0 || n == 0)
            return 0;
        if (mem[n][target] != -1)
            return mem[n][target];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            target -= i;
            count = (count + numRollsToTarget_Backtrack(n - 1, k, target, mem) % mod) % mod;
            target += i;          //backtracking
        }
        return mem[n][target] = count;
    }
}
