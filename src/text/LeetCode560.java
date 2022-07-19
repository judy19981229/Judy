package text;

import java.util.HashMap;

public class LeetCode560 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums, 3));
    }
    //从nums[0]开始累加，当前和为sum，找和为sum - k的，中间那段就是和为k
    public static int subarraySum(int[] nums, int k) {
        //哈希表用来记录数组中从0开始到nums.length的每一个前缀和
        // 1 2 3 4 map中存储的就是 (1, 1) (3, 1) (6, 1) (10, 1)
        HashMap<Integer, Integer> map = new HashMap<>();
        //前缀和为0 有1个(如果不加这个 0 1 会少 k - 0 这种情况的个数)
        map.put(0, 1);
        //为k的字数组个数
        int count = 0;
        //当前的前缀和
        int sum = 0;
        for(int num : nums){
            //数组从nums[0]到当前num的前缀和
            sum += num;
            //找两段前缀和的差值为k，就说嘛这段字数组的和为k
            //sum - (sum - k) = k 找当前map中是否有sum - k的前缀和
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            //map.put(sum, map.getOrDefault(sum, 0) + 1);
            if(map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return count;
    }
}
