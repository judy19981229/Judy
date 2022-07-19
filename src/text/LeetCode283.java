package text;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        //特殊情况
        if(nums.length == 1) return;
        //i存放0元素
        int i = 0;
        //j用来遍历数组
        for(int j = 0; j < nums.length; j++){
            //nums[j]为0，继续循环
            if(nums[j] == 0)continue;
            //nums[j]不为0，把非0元素交换到i位置,这样最后i位置前面都是非0元素
            else{
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
    }
}
