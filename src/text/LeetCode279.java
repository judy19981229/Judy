package text;

public class LeetCode279 {
    public int numSquares(int n) {
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        //dp[i] = dp[i - j * j]的最小值(j * j < i即可) + 1
        for(int i = 1; i <= n; i++){
            int min = n + 1;
            //这里要 <= 不然会出错
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
