package text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.toArray();
    }
    public int[][] merge(int[][] intervals) {
        //排序，按照每个区间的开始位置升序排列
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] v1, int[] v2){
                return v1[0] - v2[0];
            }
        });
        //集合，里面存放的是合并后的区间
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            //如果集合size为0，把第一个区间放入集合
            if(list.size() == 0){
                list.add(intervals[0]);
            }
            //如果当前区间的开始值小于等于上一个区间的结束值，那么这两个区间可以合并
            else if(intervals[i][0] <= list.get(list.size() - 1)[1]){
                //只需要更改上一个区间的结束值即可(是两个可以合并的区间的结束值中较大的那个)
                int[] tmp = list.get(list.size() - 1);
                //list.remove(list.size() - 1);
                //list.add(new int[]{tmp[0], Math.max(tmp[1], intervals[i][1])});
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
            //如果当前区间的开始值大于上一个区间的结束值，那么不能合并，直接把当前区间放入集合中
            else{ //intervals[i][0] > list.get(list.size() - 1)[1]
                list.add(intervals[i]);
            }
        }
        //把存放了一维数组的集合转成二维数组(里面传入一个new int[][] 二维数组)
        return list.toArray(new int[list.size()][2]);
    }

}
