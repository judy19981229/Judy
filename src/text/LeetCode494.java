package text;

public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        //先求nums的和
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //特殊情况，如果target的绝对值比nums的和的绝对值要大，那么结果为0(全加/全减也不够target)
        if(Math.abs(target) > Math.abs(sum)) return 0;
        //运算之后的结果应该是在 -sum 到 0 到 sum 之间，一共 2 * sum + 1种可能(加的1是0)
        //dp[i][j]表示 nums数组的0到i下标位置的数字运算后有几种可能凑出j
        int[][] dp = new int[length][2 * sum + 1];
        //j应该是从 -sum 到 sum, 但是数组只能从0开始
        //所以我们给所有的j值都加上一个sum, 0表示-sum / sum表示0 / 2 * sum表示sum
        //防止nums[0]为0，我们这里使用+=
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for(int i = 1; i < length; i++){
            //j的范围是从-sum 到 sum
            for(int j = -sum; j <= sum; j++){
                //下标0到i凑出j的值，等于下标0到i-1凑出j + nums[i]和j - nums[i]两个的和
                //我们要判断一下j + nums[i] 和 j - nums[i] 是否越界， 大于sum/小于-sum
                if(j + nums[i] > sum){
                    dp[i][j + sum] = dp[i - 1][j - nums[i] + sum];
                }
                else if(j - nums[i] < -sum){
                    dp[i][j + sum] = dp[i - 1][j + nums[i] + sum];
                }else{
                    dp[i][j + sum] = dp[i - 1][j - nums[i] + sum] + dp[i - 1][j + nums[i] + sum];
                }
            }
        }
        return dp[length - 1][sum + target];
    }
    int count = 0;
    public int findTargetSumWaysBack(int[] nums, int target) {
        backTrack(nums, target, 0, 0);
        return count;
    }
    public void backTrack(int[] nums, int target, int index, int sum){
        if(index == nums.length){
            if(sum == target) count++;
        }else{
            backTrack(nums, target, index + 1, sum + nums[index]);
            backTrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
