package text;

public class LeetCode55 {
    public boolean canJump(int[] nums) {
        //特殊情况，只有一个 肯定能到最后一个下标
        if(nums.length == 1) return true;
        //特殊情况，不止一个且第一个就是0
        if(nums[0] == 0) return false;
        //最后一个值不用管，循环到nums.length - 2即可
        for(int i = 0; i < nums.length - 1; i++){
            //遇到0，往回遍历，如果前面所有下标都跳不过这个0，那么就返回false
            if(nums[i] == 0) {
                for(int j = i - 1; j >= 0; j--){
                    if(nums[j] <= i - j){
                        //如果j走到0了，就说明i前面所有下标都跳不过这个0
                        if(j == 0) return false;
                    }else{
                        //只要有一个能跳过这个0，那么就不用管这个0了，直接终止往回的遍历
                        break;
                    }
                }
            }
        }

        return true;
    }
}
