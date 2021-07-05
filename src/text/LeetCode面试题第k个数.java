package text;

public class LeetCode面试题第k个数 {

    public int getKthMagicNumber(int k) {
        int[] nums=new int [k];//k大小的数组
        int p3=0;
        int p5=0;
        int p7=0;
        nums[0]=1;//第一个数为0
        for(int i=1;i<k;i++){
            //比较3，5，7各自对应的最小值再次乘3，5，7的最小值
            nums[i]=Math.min(3*nums[p3],Math.min(5*nums[p5],7*nums[p7]));
            if(nums[i]==3*nums[p3]){p3++;}
            if(nums[i]==5*nums[p5]){p5++;}
            if(nums[i]==7*nums[p7]){p7++;}
            //如果最小值是两个相等的，那么两个指针一起加一
        }
        return nums[k-1];//数组下标从0开始，第k个数下标为k-1
    }
}
