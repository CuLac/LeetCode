package Daily.DynamicProgramming;

/*

518. Coin Change II
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.



Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1


Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.


Example 3:

Input: amount = 10, coins = [10]
Output: 1


Approach
The intuitive way to approach this problem is by leveraging dynamic programming. We can envision a solution where,
for each coin, we update the number of ways to create every amount from 0 to the given amount.


Using a 1D Dynamic Programming Array
To find the solution in an optimized manner, we use a one-dimensional array, dp, of size amount + 1,
where dp[i] represents the number of ways to make up the amount i using the coins considered so far.

Initialize dp with all zeros and set dp[0] to 1 since there's only one way to make up amount 0, which is by not choosing any coin.
For each coin in coins, update the array dp from the coin value to the total amount.
For each amount i from the coin value to the total amount, increment dp[i] by dp[i - coin_value].
The final answer will be dp[amount].

Example
Given the sample example with coins ([1,2,5]) and amount (5), let's visualize how the dp array changes with each iteration:

Initialization:

dp = [1, 0, 0, 0, 0, 0]
Processing coin (1):

For each (j) from (1) to (5), add dp[j - 1] to dp[j]
After this step: dp = [1, 1, 1, 1, 1, 1]
Processing coin (2):

For each (j) from (2) to (5), add dp[j - 2] to dp[j]
After this step: dp = [1, 1, 2, 2, 3, 3]
Processing coin (5):

For (j = 5), add dp[0] to dp[5]
After this step: dp = [1, 1, 2, 2, 3, 4]
Now, let's visualize these iterations using a table.


Rationale
The solution's efficiency comes from its bottom-up construction.
By building upon previously computed solutions for smaller amounts, we avoid redundant calculations.
This method ensures that by the time we want to compute the number of ways for a particular amount,
we've already determined the number of ways for all smaller amounts using the current set of coins.

Complexity
Time Complexity: O(amount×len(coins))O(\text{amount} \times \text{len(coins)})O(amount×len(coins))

Space Complexity: O(amount)O(\text{amount})O(amount)

This optimized solution ensures that we're using both time and space resources efficiently.


Conclusion
The "Coin Change II" problem is an excellent demonstration of the power and efficiency of dynamic programming.
By breaking down the problem into smaller subproblems and building the solution from the ground up,
we're able to solve a seemingly complex problem in a computationally efficient manner.

Whether you're preparing for interviews or just honing your algorithmic skills,
problems like this reinforce the importance of understanding the underlying principles of
dynamic programming and applying them in various scenarios.
Keep practicing, and never stop learning!

 */

public class Q518_Coin_Change_II {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
