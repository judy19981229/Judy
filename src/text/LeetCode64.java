package text;

public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        //行数
        int rows = grid.length;
        //列数
        int columns = grid[0].length;
        //动态规划数组
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        /* 单独处理第一行第一列
        for(int i = 1; i < rows; i ++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for(int j = 1; j < columns; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        //找到从左上角到每一格的最小路径和，和当前格的左边格还有上面格有关，找出这两个中小的那个
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < columns; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

            }
        }
        */
        //把第一行和第一列加入判断条件,防止数组下标溢出
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(i == 0 && j == 0) continue;
                else if(i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if(j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

            }
        }
        return dp[rows - 1][columns - 1];
    }
}
