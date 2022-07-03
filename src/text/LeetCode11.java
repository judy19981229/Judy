package text;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        //双指针，每次往中间移动移动高度较小的那一个指针
        while(left < right){
            max = Math.max(max, (right - left) *(Math.min(height[left], height[right])));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
