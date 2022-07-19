package text;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        //return HashMap(nums);
        //return sort(nums);
        return candidate(nums);
    }
    public int HashMap(int[] nums){
        //如果数组长度为1，则这个值就是多数元素
        if(nums.length==1){return nums[0];}
        //通过HashMap的key存储数组中的元素，value存储元素出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //如果key存在，表明曾经出现过，+1之后如果大于n/2，则为多数元素，不大于就继续遍历
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                if(count+1>nums.length/2){
                    return nums[i];
                }
                map.put(nums[i],count+1);
                continue;
            }
            //如果key不存在，先存入HashMap中，value为1（表示出现1次）
            map.put(nums[i],1);
        }
        return 0;
    }
    public int sort(int[] nums){
        //排序数组
        Arrays.sort(nums);
        //length/2处一定是多数元素（出现次数大于length/2）
        return nums[nums.length/2];
    }
    //候选人投票法，多数元素个数-其余元素个数一定>1
    public int candidate(int[] nums){
        //投票法，候选人初始化为nums[0]，票数初始化为1
        int candidate=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            //和候选人相同元素，则票数+1
            //和候选人不同元素，则票数-1
            if(nums[i]==candidate){
                count++;
            }
            else if(--count==0){
                //候选人票数为0之后，更换新候选人
                candidate=nums[i];
                count=1;
            }
        }
        //最终候选人一定是多数元素
        return candidate;
    }
}
