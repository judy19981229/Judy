package text;

import java.util.Arrays;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        //特殊情况
        if(amount == 0) return 0;
        //动态规划数组，长度为amount + 1，从1计算到amount，分别把凑成他们的最少个数存在数组中
        int[] dp = new int[amount + 1];
        //把数组填满，值全部为amount + 1
        Arrays.fill(dp, amount + 1);
        //dp[0]设置为0，如果amount为0的时候，直接返回dp[0]的值0
        dp[0] = 0;
        //从1开始循环，循环到amount
        //11的最少个数是 Math.min(11 - 1的最少，11 - 2的最少，11 - 5的最少) + 1
        for(int i = 1; i < dp.length; i++){
            //遍历coins数组，通过i - coin来找可以凑成i的最少个数
            for(int coin : coins){
                //如果当前的i值大于等于coins数组里面的值，那么说明i值可能可以凑成
                if(i - coin >= 0){
                    //把遍历出来的多个dp[i - coin]进行比较，找出凑成的多个结果中的最少个数
                    //这里比较dp[i](之前的最少个数)和dp[i - coin](减去当前coin值的最少个数)时
                    //需要把dp[i - coin]加1，加上减去的coin， 11的最优解是 6的最优解+ 1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //如果dp[amount]的值是amount + 1,那么一定没有解，返回-1
        //如果amount有解，那么dp[amount]的值一定不是amount + 1 最优解就是dp[amount]的值
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
