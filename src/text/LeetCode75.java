package text;

public class LeetCode75 {
    public void sortColors(int[] nums) {
        //双指针
        int left = 0;
        int right = nums.length - 1;
        //用i遍历数组，i走到right右指针右面的时候结束循环
        int i = 0;
        while(i <= right){
            //如果i位置的值为0，直接把0交换到left指针位置即可，i往后走，循环i + 1
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                //因为i是从left位置走过来的，所以left位置的值肯定是1，所以不用判断直接继续循环
                i++;
            }
            //如果i位置的值为2，那么要把i位置的2交换到right指针位置
            //同时继续判断交换过来的这个值是否需要再次交换（可能交换过来了一个0或者一个2）
            //i先不往后走，继续循环i位置
            else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }
            //如果i位置的值为1，不用交换，i往后走，循环i + 1
            else{
                i++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
