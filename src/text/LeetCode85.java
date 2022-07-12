package text;

import java.util.Arrays;

public class LeetCode85 {
    public int maximalRectangle(char[][] matrix) {
        //宽m
        int m = matrix.length;
        //特殊情况
        if(m == 0) return 0;
        //长n
        int n = matrix[0].length;
        //left数组：记录i j位置及i j位置左边的连续的1的个数
        int[][] left = new int[m][n];
        //最大矩形的面积
        int max = 0;
        //动态规划记录左边个数
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //如果当前值为1
                if(matrix[i][j] == '1'){
                    //j = 0时说明在第一列，左边的1的个数为0
                    //j != 0时左边的连续的1的个数为left[i][j - 1];
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
                //当前值为0的时候不用处理，int数组有一个默认值0
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //如果当前值为0，不用计算，直接下次循环
                if (matrix[i][j] == '0') {
                    continue;
                }
                //当前矩形的长，初始值为i j位置及左边连续的1的个数
                int width = left[i][j];
                //当前矩形的面积为宽 * 高，初始值为widh的初始值
                int area = width;
                //从i - 1开始循环（找当前位置 上面位置 - 当前行的上面行）
                for(int k = i - 1; k >= 0; k--){
                    //widh是k j位置和i j位置中连续1较少的那个
                    width = Math.min(width, left[k][j]);
                    //当前矩形面积是width * (i - k + 1)，找较大的面积
                    area = Math.max(area, width * (i - k + 1));
                }
                //判断总的最大矩形面积
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
