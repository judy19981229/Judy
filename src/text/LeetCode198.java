package text;

public class LeetCode198 {
    public int rob(int[] nums) {
        //特殊情况
        if(nums.length == 1) return nums[0];
        //当前屋子前两间屋子可以偷到的最高金额
        int preTwo = nums[0];
        //当前屋子前一间屋子可以偷到的最高金额
        int preOne = Math.max(nums[0], nums[1]);
        //i从2开始，表示从第3间屋子开始
        for(int i = 2; i < nums.length; i++){
            //当前屋子可以偷到的最大金额是
            //偷第前一间屋子的最大金额，和偷前两间屋子的最大金额加上当前屋子金额nums[i]
            //二者中较大的那个
            int cur = Math.max(preOne, preTwo + nums[i]);
            //前两间屋子和前一间屋子的最大金额分别向后走一步
            preTwo = preOne;
            preOne = cur;
        }
        //最后preOne中保存了当前屋子的最大金额
        return preOne;
    }
    public int robDP(int[] nums) {
        //特殊情况
        if(nums.length == 1) return nums[0];
        //动态规划，dp[i]表示偷到第i间屋子可以偷到的最多金额
        int[] dp = new int[nums.length + 1];
        //偷0间屋子0元
        dp[0] = 0;
        //偷1间屋子nums[0]元
        dp[1] = nums[0];
        //i从2开始循环，循环到nums.length
        for(int i = 2; i <= nums.length; i++){
            //偷第i间屋子能偷到的最大金额为
            //偷第i - 1间屋子的最大金额，和偷第i - 2间屋子的最大金额加上第i间屋子有的金额nums[i - 1]
            //二者中较大的那个
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        //偷第nums.length间屋子能偷到的最大金额
        return dp[nums.length];
    }
}
