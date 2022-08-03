package text;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        if(length == 1) return false;
        int sum = 0;
        int max = nums[0];
        for(int i = 0; i < length; i++){
            sum += nums[i];
            if(nums[i] > max) max = nums[i];
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        if(max > sum / 2) return false;
        //dp[i][target] 表示数组的前i个元素中能否有相加等于target的组合(
        //i个元素里面有几个元素相加正好等于target
        boolean[][] dp = new boolean[length][target + 1];
        //如果target为0，那么全为true
        for(int i = 0; i < length; i++){
            dp[i][0] = true;
        }
        //如果i为0，那么只有target为nums[0]的时候为true
        dp[0][nums[0]] = true;
        for(int i = 1; i < length; i++){
            for(int j = 1; j <= target; j++){
                //dp[i][j]一定取决于dp[i - 1][j](0到i - 1能否凑出j)
                //如果j比nums[i]大，那么dp[i][j]还可以取决于dp[i - 1][j - nums[i]]
                //(0到i - 1 能否凑出j - nums[i])
                if(j > nums[i]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length - 1][target];
    }
}
