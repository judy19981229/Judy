package text;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 1) return nums[0] == target ? 1 : 0;
        int minLength = nums.length + 1;
        int sum = 0;
        for(int i = 0, j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }
}
