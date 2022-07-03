package text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //特殊情况
        if(nums.length < 3) return result;
        //先排序
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            //排序好的nums[i]大于0了，后面的也都大于0，结束循环
            if(nums[i] > 0) break;
            //和前一位值相同，去重，直接进行下一次循环
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //进行去重操作，找到下一个不相同的值
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }else if(sum > 0){
                    while(left < right && nums[right] == nums[--right]);
                }else{ //sum < 0
                    while(left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result;
    }
}
