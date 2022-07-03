package text;

import java.util.List;

public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        //动态规划(从下往上找最小路径和，然后依次加起来)
        //找到倒数第二排的每一个结点最小路径和(根据倒数第一排)，保存起来
        //找到倒数第三排的每一个结点最小路径和(根据倒数第二排)，保存起来
        //...
        //找到第一排的最小路径和(根据第二排)，返回结果
        //dp数组用来存储每一行的每一个结点的最小路径和,最后的答案存在dp[0][0]中
        /*
        int[][] dp = new int[size + 1][size + 1];
        //循环，行i从最后一行开始到第一行, 列j从第一列开始到最后一列
        for(int i = size - 1; i >=0; i--){
            for(int j = 0; j <= i; j++){
                //当前的结点的最小路径和是，下一层结点/下一层后面一个结点的最小路径和加上当前结点的值
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) +
                    triangle.get(i).get(j);
            }
        }
        return dp[0][0];
        */

        //计算dp[i][j]时，只用到了下一行的dp[i+1][j] 和 dp[i+1][j+1]。
        //dp数组可以变成一维数组，只要存储当前行的每一个最小路径和就行了，因为每次计算上一行时都会累加

        int[] dp = new int[size + 1];
        for(int i = size - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
}
