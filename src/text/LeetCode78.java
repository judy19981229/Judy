package text;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //回溯，从下标0位置开始
        backTrack(nums, 0);
        return result;
    }
    public void backTrack(int[] nums, int index){
        //每次回溯开始的时候都把当前list存入result集中 首次加进来的是空集
        //这里要写new ArrayList<>(list) 不然存入的list会为空
        result.add(new ArrayList<>(list));
        //如果index走到nums.length 说明都回溯完了
        if(index == nums.length) return;
        //从index开始回溯，回溯到nums.length - 1
        for(int i = index; i < nums.length; i++){
            //把nums[i]放入list集合中
            list.add(nums[i]);
            //继续回溯i + 1位置
            backTrack(nums, i + 1);
            //回溯完把当前位置的元素删除掉,相当于回退
            list.remove(list.size() - 1);
        }
    }
}
