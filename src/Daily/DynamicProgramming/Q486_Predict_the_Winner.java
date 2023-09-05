package Daily.DynamicProgramming;

/*

486. Predict the Winner
You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0.
At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1])
which reduces the size of the array by 1. The player adds the chosen number to their score.
The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner,
and you should also return true. You may assume that both players are playing optimally.

Example 1:

Input: nums = [1,5,2]
Output: false
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return false.
Example 2:

Input: nums = [1,5,233,7]
Output: true
Explanation: Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

 */


/*

Approach
To solve this problem, I leveraged dynamic programming (DP). The primary logic revolves around setting up a 2D DP array, dp[i][j],
where each cell signifies the maximum possible score the first player can achieve over the second player.
This score is derived from a subarray of the original array, starting from index i to j.

Here's the detailed breakdown of the approach:

Initialization:
I initialized the DP array diagonally. This step was necessary because, when there is only one element left to pick (i.e., i == j),
the player will take that number, and hence dp[i][j] = nums[i].

State Transition:
For every cell dp[i][j] in the DP array, the first player has two choices: either pick the i-th number or the j-th number.
Each choice leads to a different state:

If the first player picks the i-th number, the remaining array becomes nums[i+1 : j+1]. Now it's the second player's turn.
Given that the second player also plays optimally to maximize his net score,
he will pick a number which leaves the first player with a minimum net score.
This results in a state transition to dp[i+1][j], causing the net score for the first player to be nums[i] - dp[i+1][j].

Similarly, if the first player picks the j-th number, the remaining array becomes nums[i : j].
This results in a state transition to dp[i][j-1], leading to a net score for the first player of nums[j] - dp[i][j-1].

Choice: For each dp[i][j], the first player will choose the maximum net score between the two possible state transitions.
Hence, dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]).

Final Decision: I examined dp[0][n-1] to determine the outcome of the game. If dp[0][n-1] is non-negative,
it means the first player can win or tie the game, so I returned True. Otherwise, I returned False.
This is because dp[0][n-1] represents the maximum net score the first player can get over the second player by considering the entire array.
If this score is non-negative, the first player can secure a win or at least a tie.

Complexity
Time complexity: The time complexity of this solution is (O(n^2)), where (n) is the length of the input array.
This is because we have to fill up the (n \times n) DP table.

Space complexity: The space complexity is also (O(n^2)) for the DP table.

This code follows the approach I mentioned above and solves the problem by building a dynamic programming table and then
using that table to determine if the first player can win.

 */

public class Q486_Predict_the_Winner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
