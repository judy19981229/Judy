package text;

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        //特殊情况
        if(nums.length == 1) return nums[0];
        //总的最大值
        int max = nums[0];
        //到目前为止的连续最大值
        int preMax = nums[0];
        //因为把max和preMax都设置为0，所以循环从第二个数开始
        for(int i = 1; i < nums.length; i++){
            //到目前为止的最大值是加上nums[i]和nums[i]中较大的那个
            preMax = Math.max(preMax + nums[i], nums[i]);
            //总的最大值是之前总的最大值和到目前为止的最大值中较大的那个
            max = Math.max(max, preMax);
        }
        return max;
    }
}
