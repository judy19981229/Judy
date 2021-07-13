package text;

import java.util.HashMap;

public class LeetCode1124 {

    public static void main(String[] args) {
        int[] hours=new int[]{9,9,6,0,6,6,9};
        longestWPI(hours);
    }
    public static int longestWPI(int[] hours) {
        int sum=0;
        int res=0;
        HashMap<Integer,Integer> sumToIndex=new HashMap<>();
        for(int i=0;i< hours.length;i++){
            if(hours[i]>8){sum++;}
            else{sum--;}
            if(sum>0){res=i+1;}
            //从头开始遍历，如果sum>0，说明从开始到现在必然表现良好
            else{
                if(!sumToIndex.containsKey(sum)){
                    sumToIndex.put(sum,i);//记录sum第一次出现的位置
                }
                if(sumToIndex.containsKey(sum-1)){
                    res=Math.max(res,i-sumToIndex.get(sum-1));
                }
            }
        }
        return res;
    }
}
