package text;

import java.util.Arrays;

public class ChaRuSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,3,7,2,5,8,1,4};
        //i应该从第二个元素开始循环到数组的最后一个元素(i代表待插入元素的索引)
        //每次都把0-i排序好，就是把nums[i]移动到合适的位置
        for(int i = 1; i <nums.length; i++){
            //记录nums[i]
            int cur = nums[i];
            //从nums[i]前一个元素开始遍历，找到所有比nums[i]大的元素
            //把他们依次后移一位（会覆盖原先大nums[i]，所以要先记录下来)，找到最后一个比他大的元素的位置
            //然后把原先的nums[i]放到最后一个比他大的元素的位置
            //因为最后一个比他大的元素的位置已经后移了一位，所以现在nums[i]已经在合适的位置了(前小后大)
            int j = i - 1;
            for(; j >= 0 && nums[j] > cur; j--){
                nums[j + 1] = nums[j];
            }
            //这里因为上面循环结束的时候j - 1了，所以把原先的nums[i]放到j + 1的位置上
            nums[j + 1] = cur;
            System.out.println(Arrays.toString(nums));
        }

    }
}
