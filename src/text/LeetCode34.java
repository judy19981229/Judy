package text;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        //第一个大于target - 1的数的下标（第一个target的下标）
        int left = binarySearch(nums, target - 1);
        //第一个大于target的数的下标（最后一个target下一个下标，减一就是最后一个target的下标）
        int right = binarySearch(nums, target) - 1;
        //条件判断
        if(left <= right && nums[left] == target){
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    // 第一个大于 target 的数的下标
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //result的初始值要定义为right + 1(也就是nums.length) 防止一开始target ==  nums[right]
        int result = nums.length;
        while(left <= right){
            int middle = (right - left) / 2 + left;
            if(nums[middle] > target){
                right = middle - 1;
                result = middle;
            }else{
                left = middle + 1;
            }
        }
        return result;
    }

}
