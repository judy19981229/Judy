package text;

public class LeetCode338 {
    public int[] countBits(int n) {
        int[] nums=new int[n+1];
        nums[0]=0;
        for(int i=1;i<=n;i++){
            nums[i]=nums[i&(i-1)]+1;
        }
        return nums;
    }
}
