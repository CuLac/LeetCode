package Daily.DynamicProgramming;

import com.google.gson.Gson;

import java.util.Arrays;

public class Q673_Number_of_Longest_Increasing_Subsequence {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (nums.length == 0)
            return 0;

        /*tao 2 mang luu gia tri:
        * - dp: mang luu do dai cac mang con co gia tri tang dan
        * - count: so luong mang con tuong ung voi dp
        * */
        int[] dp = new int[n];
        int[] count = new int[n];

        // fill giá tri 1 vao 2 mang
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxlength = 0;

        //khoi tao 2 vong for de quet mang
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    /* Neu gia tri nums[i] > nums[j]
                    => do dai cua mang toi da tang them 1
                    => so luong tuong ung cua mang cung se thay doi tu count[i] sang thanh count[j]
                    */
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else {
                        count[i] += count[j];
                    }
                }
            }

            //tim ra do dai cua mang con lon nhat
            maxlength = Math.max(maxlength, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxlength) {
                result += count[i];
            }
        }
        return result;
    }
}
