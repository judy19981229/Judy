package text;

import java.util.HashMap;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums={3,2,4};
        int target=6;
        int[] result =twoSum(nums,target);
        for(int i:result){
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        //map存放的key是数组中的值，value为该值的下标
        HashMap<Integer,Integer> map=new HashMap();
        int[] result= new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=i;
                result[1]= (int) map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static int[] twoSum1(int[] nums, int target){
        int[] result= new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

}
