package text;

import java.util.Arrays;

public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        //动态规划，到m n位置的路径数 = 到m - 1 n位置的路径数 + 到 m n - 1位置的路径数
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //第一行和第一列（i为0 或者 j为0）的值都为1，只有一条路径
                if(i == 0 || j == 0) dp[i][j] = 1;
                    //不在第一行和第一列（i和j都不为0）的值为到它左边的值加到它上面的值
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        //最终结果存在dp[m - 1][n - 1]
        return dp[m - 1][n - 1];
    }
}
