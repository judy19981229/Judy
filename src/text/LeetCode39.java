package text;

import java.util.*;

public class LeetCode39 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序（升序）是剪枝的前提
        Arrays.sort(candidates);
        //回溯
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] candidates, int begin, int target) {
        //回溯终止条件：target == 0 说明已经找到一组解
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //从begin开始循环回溯
        for (int i = begin; i < candidates.length; i++) {
            //candidates已经升序了，target - candidates[i] < 0 后面的都不符合条件了
            if (target - candidates[i] < 0) {
                break;
            }
            //把candidates[i]放入组合中
            path.addLast(candidates[i]);
            //回溯找target-candidates[i]的组合
            dfs(candidates, i, target - candidates[i]);
            //移除candidates[i]，继续循环回溯candidates[i + 1]
            path.removeLast();
        }
    }

}
