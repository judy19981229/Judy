package text;

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        //i从倒数第二个位置开始往前找，找到一段降序排列的前面一个位置
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        //如果i为负数，说明是完全降序的，直接把数组整个反转即可
        if(i >= 0){
            //如果i不为负数，找到降序序列中第一个比i大的值，记录下标为j
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            //交换i和j位置的值
            swap(nums, i, j);
        }
        //反转i后面到末尾的所有值
        reverse(nums, i + 1);
    }
    //交换数组i和j下标位置的值
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    //反转数组从start下标开始到末尾的所有值
    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start < end){
            swap(nums, start++, end--);
        }
    }
}
