package text;

public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if(length == 1) return 0;
        int left = -1;
        int right = -1;
        //数组分三段，左(升序) 中(乱序) 右(升序)
        //从左往右，找到比左边最大值还小的最右下标，从右往左，找到比右边最小值还大的最左下标
        //左边通过最大值找降序，找到最后一个，就是子数组的右边位置
        //右边通过最小值找升序，找到最后一个，就是子数组的左边位置
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < length; i++){
            //从左边开始找最大值，找最后一个小于最大值的
            if(max > nums[i]){
                right = i;
            }else{
                max = nums[i];
            }
            //从右边开始找最小值，找最后一个大于最小值的
            if(min < nums[length - 1 - i]){
                left = length - 1 - i;
            }else{
                min = nums[length - 1 - i];
            }
        }
        //如果right不为-1，说明有；如果right为-1，说明没有
        return right == -1 ? 0 : right - left + 1;
    }

}
