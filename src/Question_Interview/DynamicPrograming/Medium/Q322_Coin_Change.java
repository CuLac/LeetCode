package Question_Interview.DynamicPrograming.Medium;

/*

322. Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

 */

import com.google.gson.Gson;

public class Q322_Coin_Change {

    //sử dụng đệ quy
    public int coinChange(int[] coins, int amount) {
        if(amount<0) return -1;
        if(amount==0) return 0;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange(coins, amount-coins[i]);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        return cc;
    }

    //sử dụng DP
    public static int coinChange_v2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i=1; i < dp.length; i++) {
            dp[i] = dp.length;
            for (int j=0; j < coins.length; j++) {
                if (i >= coins[j]) dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        System.out.println(new Gson().toJson(dp));
        return dp[amount] == dp.length ? -1 : dp[amount];
    }
}
