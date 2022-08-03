package text;

public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //行数
        int m = obstacleGrid.length;
        //列数
        int n = obstacleGrid[0].length;
        //dp[i][j]表示到i j位置的路径数
        int[][] dp = new int[m][n];
        //第一行的路径数一定为1，如果碰到不能通过的，那后面都为0
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        //第一列的路径数一定为1，如果碰到不能通过的，那后面都为0
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                //如果当前位置不能通过，那么路径数为0
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                /* 这里可以省略不写
                //如果当前位置左边和上面都不能通过，那么路径数为0
                else if(obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1){
                    dp[i][j] = 0;
                }
                //如果当前位置左边不能通过，那么当前位置的路径数等于上面位置的路径数
                else if(obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] != 1){
                    dp[i][j] = dp[i][j - 1];
                }
                //如果当前位置上面不能通过，那么当前位置的路径数等于左边位置的路径数
                else if(obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] != 1){
                    dp[i][j] = dp[i - 1][j];
                }
                */
                //当前位置上面和左面都能通过，路径数等于左面位置的路径数+上面位置的路径数
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        //终点位置为m - 1 n - 1
        return dp[m - 1][n - 1];
    }
}
