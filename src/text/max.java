package text;

import java.util.Arrays;

public class max {
    public static void main(String[] args) {
        int max=0;
        int[] nums={-4,-1,3,8,6};
        Arrays.sort(nums);
        int num=nums.length;
        if(nums[0]>0 || (nums[0]<0 && nums[num-1]<0) ){
            max=nums[num-1]*nums[num-2]*nums[num-3];
        }
        else{
            int max1=nums[num-1]*nums[num-2]*nums[num-3];
            int max2=nums[0]*nums[1]*nums[num-1];
            if(max1>max2){
                max=max1;
            }else{
                max=max2;
            }
        }
        System.out.println(max);
    }
}
