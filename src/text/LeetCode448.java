package text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode448 {
    //用一个新的int数组tmp，把tmp中nums[i] - 1下标位置设置-1，最后找tmp数组中下标不是-1的位置 +1即可
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        //特殊情况
        if(nums.length == 1) return list;
        //记录数字出现的数组，下标0到length - 1 对应 数字1 到 length
        int[] tmp = new int[length];
        //把出现数字对应的下标位置的值置 - 1
        for(int i = 0; i < length; i++){
            tmp[nums[i] - 1] = -1;
        }
        //如果下标处值不是-1，就是消失的数字
        for(int i = 0; i < length; i++){
            if(tmp[i] != -1){
                list.add(i + 1);
            }
        }
        return list;
    }
    //用HashSet存入数组中的所有值，如果1到length不在set中，就是消失的数字(但是HashSet很慢,还不如用HashMap)
    public List<Integer> findDisappearedNumbersSet(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        if(nums.length == 1) return list;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i = 1; i <= length; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
