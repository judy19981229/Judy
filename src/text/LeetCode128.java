package text;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCode128 {

    //HashSet
    public int longestConsecutive(int[] nums) {
        //特殊情况
        if(nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int max = 1;
        for (int num : set) {
            //如果set中包含num - 1 那么计算num - 1的最长连续序列时会计算到当前num，无需计算
            if (!set.contains(num - 1)) {
                //count记录当前num的连续序列
                int count = 1;
                //tmp用来从num开始向后遍历，查找是否是连续的
                int tmp = num + 1;
                while(set.contains(tmp)){
                    tmp++;
                    count++;
                }
                //判断最大值
                max = Math.max(max, count);
            }
        }
        return max;
    }
    //排序法
    public int longestConsecutiveSort(int[] nums) {
        //特殊情况
        if(nums.length <= 1) return nums.length;
        //排序
        Arrays.sort(nums);
        //count是当前连续序列
        int count = 1;
        //max是当前最长连续序列
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            //nums[i]和nums[i - 1]差为1，当前连续序列+1，判断
            if(nums[i] - nums[i - 1] == 1){
                count++;
                max= Math.max(max, count);
            }else if(nums[i] - nums[i - 1] == 0){
                continue;
            }
            else{
                count = 1;
            }
        }
        return max;
    }
}
