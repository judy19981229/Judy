package text;

import java.util.LinkedList;

public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= 1) return nums;
        //滑动窗口从下标0开始，走到nums.length - k结束，长度为nums.length - k + 1
        int[] result = new int[nums.length - k + 1];
        //通过双向队列来维护一个递减的窗口，保证窗口的第一位一定是最大值
        //从0开始遍历到k - 1之后，窗口形成，之后每次都把窗口第一位放入结果集即可
        LinkedList<Integer> window = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            // ** 但是窗口中存的是当前值对应的数组下标，方便判断 **
            //先进行判断，如果要入队的值比之前窗口中的值大，则出队那些小的值，保持窗口递减
            while(!window.isEmpty() && nums[i] > nums[window.peekLast()]){
                window.pollLast();
            }
            //然后入队
            window.addLast(i);
            //判断窗口入队之后队首元素的下标是否越界（如果小于i - k说明超过了k个元素）
            if(window.peek() <= i - k){
                window.poll();
            }
            //窗口长度为k的时候（i走到k - 1的位置之后，结果数组的下标从 i - (k - 1) = 0 开始）
            if(i >= k - 1){
                result[i - k + 1] = nums[window.peek()];
            }
        }
        return result;
    }
}

