package text;

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        //left[i]表示i位置左边所有元素的乘积
        int[] left = new int[length];
        //right[i]表示i位置右边所有元素的乘积
        int[] right = new int[length];
        //左边乘积初始值为1
        left[0] = 1;
        //右边乘积初始值为1
        right[length - 1] = 1;
        //计算i位置左边所有元素的乘积，存入left[i]
        for(int i = 1; i <= length - 1; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        //计算i位置右边所有元素的乘积，存入right[i]
        for(int i = length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }
        //除i位置以外所有元素乘积 = 左边乘积 * 右边乘积
        for(int i = 0; i < length; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }

}
