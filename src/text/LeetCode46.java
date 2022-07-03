package text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode46 {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        //先把nums中的所有数字放入一个list集合中
        for(int num : nums){
            list.add(num);
        }
        //从下标0位置开始回溯
        backTrack(list, length, 0);
        return result;
    }
    //回溯方法的参数：存放每次回溯结果的集合，集合中数字个数，本次回溯开始数字的下标
    public static void backTrack(List<Integer> list, int length, int index) {
        if (index == length) {
            //回溯完所有数字，把list集合放入结果集中
            result.add(new ArrayList<Integer>(list));
        }
        //从index开始回溯
        for (int i = index; i < length; i++) {
            //先把i和index位置下标的数字交换
            Collections.swap(list, i, index);
            //继续递归下一个数字
            backTrack(list, length, index + 1);
            //回溯完成之后把i和index位置下标换回去
            Collections.swap(list, i, index);
        }
    }
}



