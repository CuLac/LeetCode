package Question_Interview.Arrays_String.Medium;

/*

55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 */

public class Q55_Jump_Game {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int step = 0;
        for (int i = 0; i <= step; i++) {
            step = Math.max(step, i + nums[i]);
            if (step >= n - 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJump_v2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1]=0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }
            if (nums[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i] ;j++) {
                    if (i + j < dp.length) {
                        if (dp[i + j] != Integer.MAX_VALUE)
                            min = Math.min(min, dp[i + j]);
                        else
                            dp[i]=Integer.MAX_VALUE;

                    }else{
                        dp[i] = 1;
                        break;
                    }
                }
                if(min != Integer.MAX_VALUE)dp[i]=min+1;
            }
        }
        return dp[0]!=Integer.MAX_VALUE;
    }

    public boolean canJump_v3(int[] nums) {
        int len = nums.length;
        boolean [] dp = new boolean[len];
        dp[len-1] = true;
        for(int i=len-1; i>=0; i--){
            for(int j = 1; j<=nums[i]; j++){
                System.out.println(j+"||"+i);
                dp[i]=(i+j<len-1)?dp[i+j]: true;
                if(dp[i])break;
            }
        }
        return dp[0];
    }

    public boolean canJump_v4(int[] nums) {
        return helper(nums,0);
    }
    public boolean helper(int []nums,int currIndex){
        int len = nums.length-1;
        if(currIndex>=len)return true;
        boolean ans = false;
        for(int i = nums[currIndex]; i>=1;i--){
            System.out.println(i+"||"+currIndex);
            ans = helper(nums,currIndex+i);
            if(ans)break;
        }
        System.out.println("||"+currIndex);
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {3,2,1,1,2,4};
        System.out.println(canJump(arr));
    }
}
