package text;

public class LeetCode42 {
    public int trap(int[] height) {
        //双指针，左右指针
        int left = 0;
        int right = height.length - 1;
        //左指针找左边的最大值
        int leftMax = 0;
        //右指针找右边的最大值
        int rightMax = 0;
        //结果集
        int result = 0;
        //这里可以写left < right 因为最后走到的left == right 一定是最大值位置(一直移动小的指针)
        while(left <= right){
            //找左右的最大值
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //当前位置可以接的雨水等于左右最大值中较小的那个 - 当前的值
            //右最大值小于左最大值，从右边接雨水，右指针往左移
            if(rightMax < leftMax){
                result += rightMax - height[right];
                right--;
            }
            //左最大值小于右最大值，从左边接雨水，左指针往右移
            else{
                result += leftMax - height[left];
                left++;
            }
        }
        return result;
    }
}
