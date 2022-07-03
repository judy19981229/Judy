package text;

import java.util.Arrays;

public class DuiSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,7,2,9,8,1,4};
        headSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void headSort(int[] nums){

        int length = nums.length;
        //从最后一个非叶子结点开始，构建为最大堆
        for(int i = length / 2 - 1; i >= 0; i--){
            buildMaxHead(nums, i, length - 1);
        }
        for(int i = length - 1; i > 0; i--){
            //把最大值交换到最后一位
            swap(nums, 0, i);
            //排除最后一位，把前面继续构建成最大堆
            buildMaxHead(nums, 0, i - 1);
        }
    }
    //构建从i结点到length结点这一段为最大堆
    public static void buildMaxHead(int[] nums, int i, int length){
        int tmp = nums[i];
        int j;
        while((j = 2 * i + 1) <= length){
            //找大的子结点
            if(j + 1 <= length && nums[j + 1] > nums[j]){
                j++;
            }
            //两个子结点都比根结点小，可以结束循环
            if(nums[j] <= tmp) break;
            //(nums[j] > tmp) 大的子节点放到根结点位置,i走到j，继续循环找大的子节点
            nums[i] = nums[j];
            i = j;

        }
        nums[i] = tmp;
    }
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
