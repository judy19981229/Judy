package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        //特殊情况，只有一个柱子，它的高度就是面积
        if(length == 1) return heights[0];
        //给矩形前后各加一个0，前面的0可以让我们不用给栈判空，后面的0可以最后让所有的矩形都出栈
        int[] newHeights = new int[length + 2];
        //头0
        newHeights[0] = 0;
        //中间从旧数组拷贝
        for(int i = 0; i < length; i++){
            newHeights[i + 1] = heights[i];
        }
        //长度更新为新数组的长度
        length = newHeights.length;
        //尾0
        newHeights[length - 1] = 0;
        //指向新数组
        heights = newHeights;
        //栈中存放的是矩形的下标
        Deque<Integer> stack = new LinkedList<>();
        //先把0入栈
        stack.push(heights[0]);
        //最大值
        int max = 0;
        //从第一个矩形开始判断，如果它的面积比栈中矩形的面积小，那么栈中矩形的最大面积就确定了(无法向后延伸)
        //由于先入栈了一个0，后面入栈的矩形面积一定比0大，所以无需对栈进行判空操作
        //数组最后加入的那个0会让栈中之前没有出栈的矩形面积全部出栈，因此无需再进行栈不为空出栈操作
        for(int i = 1; i < length; i++){
            //循环，把栈顶所有大于当前矩形面积的全部出栈并计算面积
            while(heights[i] < heights[stack.peek()]){
                //高是栈顶矩形面积
                int height = heights[stack.pop()];
                //宽是当前下标到栈顶矩形下标(出栈的栈顶矩形前一个位置) - 1
                int width = i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            //如果当前矩形面积大于等于栈顶矩形面积就直接入栈当前矩形下标，
            //小于则出栈所有小于当前矩形面积的，然后再入栈当前矩形下标
            //确保栈顶一直是当前最大矩形面积的下标
            stack.push(i);
        }
        return max;
    }


    public int largestRectangleArea1(int[] heights) {
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
