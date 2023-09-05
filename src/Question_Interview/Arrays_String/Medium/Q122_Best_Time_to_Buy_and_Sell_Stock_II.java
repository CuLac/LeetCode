package Question_Interview.Arrays_String.Medium;

/*

122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 */

public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int profit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            System.out.println("i=" + i + "|Price=" + prices[i] + "|Profit=" + profit);
            if (buy > prices[i]) {
                profit += sell - buy;
                buy = prices[i];
                sell = prices[i];
                System.out.println("Buy > Price|Buy=" + buy + "|Sell=" + sell);
            } else {
                if (sell <= prices[i]) {
                    sell = prices[i];
                } else {
                    profit += (sell - buy);
                    buy = prices[i];
                    sell = prices[i];
                }
                System.out.println("Buy <= Price|Buy=" + buy + "|Sell=" + sell);
            }
        }
        profit += sell - buy;
        return profit;
    }

    public static int maxProfit_v2(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            //truong hop gia mua moi < gia mua cu ==> update gia mua moi thap hon
            if (buy > prices[i]) {
                buy = prices[i];
            } else {
                profit += (prices[i] - buy);
                buy = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,1};
        System.out.println(maxProfit(arr));
    }
}
