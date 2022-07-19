package text;

public class LeetCode152 {
    //要记录最大值和最小值(遇到负数最小值就会变成最大值)
    public int maxProduct(int[] nums) {
        //特殊情况
        if(nums.length == 1) return nums[0];
        //最大值，最初始值为nums[0]
        int max = nums[0];
        //当前最大值，初始值为1，从nums[0]开始乘，并进行判断，保留最大的那个值
        int curMax = 1;
        //当前最小值，初始值为1，从nums[0]开始乘，并进行判断，保留最小的那个值
        int curMin = 1;
        //从0开始循环
        //也可以把max、curMax、curMin都设置为nums[0]，然后从1开始循环
        for(int i = 0; i < nums.length; i++){
            //如果当前的值小于0，那么之前的最大值就会变成最小值，最小值就会变成最大值
            if(nums[i] < 0){
                //交换最小值和最大值
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            //判断当前最大值乘上当前值(累乘值)和当前值哪个更大(找累乘的最大值)
            curMax = Math.max(curMax * nums[i], nums[i]);
            //判断当前最小值乘上当前值(累乘值)和当前值哪个更小(找累乘的最小值)
            curMin = Math.min(curMin * nums[i], nums[i]);
            //判断最大值和当前最大值哪个更大(找最大值)
            max = Math.max(max, curMax);
        }
        return max;
    }
}
