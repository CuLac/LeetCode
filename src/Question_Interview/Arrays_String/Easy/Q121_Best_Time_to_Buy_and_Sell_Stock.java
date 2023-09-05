package Question_Interview.Arrays_String.Easy;

/*

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 */

public class Q121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {

        //khoi tao gia tri sell va buy
        int sell = prices[0];
        int buy = prices[0];
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < prices.length; i++) {

            // profit lon nhat khi buy nho nhat va sell lon nhat
            if (buy > prices[i]) {
                buy = prices[i];

                // do ngay ban' phai lon hon ngay mua nen khi gia tri buy thay doi thi sell cung phai thay doi
                sell = prices[i];
            } else {

                // truogn hop gia tri mua vao buy khong thay doi ==> tim sell lon nhat
                sell = Math.max(sell, prices[i]);
            }

            //so sanh profit cua tung doan voi nhauu de tim ra gia tri lon nhat
            profit = Math.max((sell - buy), profit);
        }
        return profit;
    }
}
