package text;

import java.util.Arrays;

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        //每个数的最长递增子序列都最少为1
        Arrays.fill(dp, 1);
        //最大值也最少为1
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            //找nums[i]前面小于所有nums[i]的值nums[j]，dp[i] = dp[j] + 1(这个1是nums[i])
            //再判断dp[j] + 1的最大值
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //比较所有dp[i]的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
