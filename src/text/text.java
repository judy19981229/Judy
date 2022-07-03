package text;


import java.util.ArrayList;
import java.util.List;

public class text {

    public static void main(String[] args) {
        int [] nums = new int[]{2,1,1,3,1,4,5,6};
        System.out.println(candidate(nums));
    }
    public static List<Integer> candidate(int[] nums){
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        //候选人1和候选人2 遇到相同元素则+1 遇到和双方都不同的元素则各-1
        Integer candidate1 = 0;
        Integer candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<length;i++){
            if(nums[i]==candidate1){ //候选人1相同元素，候选人1票数加1
                count1++;
            }else if(nums[i]==candidate2){ //候选人2相同元素，候选人2票数加1
                count2++;
            }else if(count1==0){ //候选人1的票数为0，更换新候选人1，票数为1
                candidate1=nums[i];
                count1++;
            }else if(count2==0){ //候选人2的票数为0，更换新候选人2，票数为1
                candidate2=nums[i];
                count2++;
            }else{ //num[i]既不等于candidate1也不等于candidate2，候选人1和2均票数-1
                count1--;
                count2--;
            }
        }
        //这时需要进行判断，候选人1和2出现的次数应该大于length/3
        count1=0;
        count2=0;
        for(int num : nums){
            if(num==candidate1){
                count1++;
            }else if(num==candidate2){
                count2++;
            }
        }
        if(count1>length/3){
            result.add(candidate1);
        }
        if(count2>length/3){
            result.add(candidate2);
        }
        return result;

    }
}

