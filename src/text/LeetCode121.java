package text;

public class LeetCode121 {
    public int maxProfit(int[] prices) {
        //特殊情况
        if(prices.length == 1) return 0;
        //用来记录到目前为止的最小值
        int minPrice = prices[0];
        //最大利润，初始值为0
        int maxProfit = 0;
        //遍历
        for(int i = 0; i < prices.length; i++){
            //如果当前值比之前记录的最小值要小，把最小值设置为当前值
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            //如果当前值比之前记录的最小值要大，减去之前的最小值，判断利润是否更高
            else if(prices[i] > minPrice){
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
