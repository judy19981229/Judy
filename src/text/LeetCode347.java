package text;

import java.util.*;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        //特殊情况
        if(nums.length == 1) return new int[]{nums[0]};
        //map的key是元素值，map的value是元素出现个数
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                int value = map.get(num);
                map.put(num, value + 1);
            }
        }
        //优先队列，存入的是map的key，根据key的value来进行排序(改成一个最大堆的优先队列)
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2){
                return map.get(num2) - map.get(num1);
            }
        });
        //把key值都存入优先队列中 map.keySet()方法 获取一个key的Set集合 value()方法 获取value集合
        for(int num : map.keySet()){
            pq.add(num);
        }
        //从优先队列中把前k个结果导入数组中
        int[] result = new int[k];
        for(int i = 0; i < result.length; i++){
            result[i] = pq.poll();
        }
        return result;
    }

}
