package text;

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        //特殊情况
        if(length == 1) return heights[0];
        int max = 0;
        for(int i = 0; i < length; i++){
            int cur = heights[i];
            //找左边最后一个大于等于cur的下标
            int left = i;
            while(left > 0 && heights[left - 1] >= cur){
                left--;
            }
            //找右边最后一个大于等于cur的下标
            int right = i;
            while(right < length - 1 && heights[right + 1] >= cur){
                right++;
            }
            //最大值就是长*宽和之前最大值进行对比
            max = Math.max(max, cur * (right - left + 1));
        }
        return max;
    }

}
