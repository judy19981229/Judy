package text;

public class LeetCode221 {
    //动态规划，dp[i][j]表示以i j位置为右下角的最大正方形的边长
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                //只有matrix[i][j] == '1'的时候才进行判断
                if(matrix[i][j] == '1'){
                    //如果在第一行或者第一列，边长为1
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        //以i j位置为右下角的最大正方形的边长
                        //为i j位置左边 左上 上边三个位置的最大正方形边长的最小值
                        //因为左上位置如果为0 即使左边 上边都为1 那么也无法构成正方形
                        int tmp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(tmp, dp[i - 1][j - 1]) + 1;
                    }
                    //判断最大边长
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        //面积是边长*边长
        return max * max;
    }

}
