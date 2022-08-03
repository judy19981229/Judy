package text;

public class LeetCode309 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        //特殊情况
        if(length == 1) return 0;

        int[][] dp = new int[length][3];
        //dp[i][0] i日持有股票(昨日买入 / 今日买入)
        //dp[i][1] i日不持有股票(今日卖出股票导致明日为冷冻期)
        //dp[i][2] i日不持有股票(今日没卖股票，有可能昨日卖出或者昨日也没持有)

        //第一日购买股票,利润为-prices[0]
        dp[0][0] = -prices[0];
        //dp[0][1] = dp[0][2] = 0;

        for(int i = 1; i < length; i++){
            //今天持有的利润 = 昨日买入 or 今日买入(昨天不持有且没卖) 中较大的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //今天卖出的利润 = 昨天持有的利润 + 今天的股票价格
            dp[i][1] = dp[i - 1][0] + prices[i];
            //今天不持有且没卖出的利润 = 昨天不持有的较大利润(昨天卖 or 没卖 中较大的那个)
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        //最终返回的是length - 1日不持有股票的较大的那个利润
        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }
}
