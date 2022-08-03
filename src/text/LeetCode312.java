package text;

public class LeetCode312 {
    public int maxCoins(int[] nums) {
        int length =nums.length;
        if(length == 1) return nums[0];
        //dp[i][j]为 从 i位置 到 j位置 戳气球 可以获得的硬币(不包括 i j 位置)
        int[][] dp = new int[length + 2][length + 2];
        //val[k]为k位置的气球的数字，因为戳气球涉及到前面一个和后面一个
        //所有要把val前后各多加一个1
        int[] val = new int[length + 2];
        val[0] = val[length + 1] = 1;
        for(int i = 1; i <= length; i++){
            val[i] = nums[i - 1];
        }
        // max = dp[i][k] + dp[j][k] + val[i] * val[j] * val[k]
        for(int i = length - 1; i >= 0; i--){
            for(int j = i + 2; j <= length + 1; j++){
                for(int k = i + 1; k < j; k++){
                    int tmp = dp[i][k] + dp[k][j] + val[i] * val[k] * val[j];
                    dp[i][j] = Math.max(dp[i][j], tmp);
                }
            }
        }
        return dp[0][length + 1];
    }
}
