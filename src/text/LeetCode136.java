package text;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LeetCode136 {
    public int singleNumber(int[] nums) {
        //数组中元素两两异或，最后就是指出现一次的数字
        /*
        任何数和0做异或运算，结果仍然是原来的数，即 a ^ 0 = a
        任何数和其自身做异或运算，结果是0，即 a ^ a = 0。
        异或运算满足交换律和结合律，即 a ^ b ^ a = a ^ a ^ b = 0 ^ b = b
        */
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }
    //用Set集合，遇到重复元素就把它从Set中移除，最后剩下的只有那个不重复的
    public int singleNumberSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                set.remove(num);
            }
        }
        //Hashset要用迭代器来遍历获取元素
        /*Iterator iterator = set.iterator();
        int result = 0;
        while(iterator.hasNext()){
            result = (int)iterator.next();
        }
        return result;*/
        return set.iterator().next();
    }
}
