package text;

import java.util.HashMap;
import java.util.Map;

public class LeetCode437 {
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        //key表示当前的前缀和(为long int会超量程)，value表示当前前缀和的个数
        HashMap<Long, Integer> map = new HashMap<>();
        //***这里一定要加入 0 1 表示前缀和为0的有1个，不然无法计算出前缀和直接等于target的情况
        map.put(0l, 1);
        long sum = 0l;
        count += sumTree(root, targetSum, sum, map);
        return count;
    }
    //向左子树/向右子树递归判断路径和
    public int sumTree(TreeNode root, int targetSum, long sum, HashMap<Long, Integer> map){
        int count = 0;
        //如果root == null 直接返回0
        if(root == null) return count;
        //到当前节点的前缀和
        sum += root.val;
        // sum - (sum - targetSum) = targetSum
        //如果有sum - targetSum的前缀和，说明相减之后有target
        if(map.containsKey(sum - targetSum)){
            count += map.get(sum - targetSum);
        }
        //把sum前缀和的个数加到map中
        if(map.containsKey(sum)){
            map.put(sum, map.get(sum) + 1);
        }else{
            map.put(sum, 1);
        }
        //计算左子树的前缀和
        count += sumTree(root.left, targetSum, sum, map);
        //计算右子树的前缀和
        count += sumTree(root.right, targetSum, sum, map);
        //向上返回的时候需要把map中当前前缀和去掉，因为向上返回根节点之后当前节点的前缀和也不存在了
        map.put(sum, map.get(sum) - 1);
        return count;
    }

}
