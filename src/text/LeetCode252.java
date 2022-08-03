package text;

import java.util.*;

public class LeetCode252 {
    public static void main(String[] args) {
        int[][] meets = new int[][]{{0,20},{10,15},{5,10},{6,9},{11,19}};
        //把二维数组按照每个一维数组的第一位升序排列(升序就是返回o1 - o2 降序就是返回o2 - o1)
        //Arrays.sort(meets,(meet1, meet2) -> meet1[0] - meet2[0]);
        Arrays.sort(meets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int[] meet : meets){
            System.out.println(Arrays.toString(meet));
        }
        System.out.println("meet[1][0] - meet[0][0] = "+(meets[1][0] - meets[0][0]));
        //优先队列，确保每次出队的都是最小值(如果想出队最大值，在new里面传入一个Comparator接口，重写compare方法)
        //优先队列是按照最小堆的方式存储的(堆顶是最小值，相当于升序)，重写compare方法的时候要改成降序o2 - o1
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //优先队列中存储的是会议结束的时间
        for(int[] meet : meets){
            if(!priorityQueue.isEmpty()){
                //如果当前会议开始的时间大于之前的会议结束的时间，说明两个会议可以公用一个会议室
                //这里由于使用了优先队列，会自动和最小值进行比较，也会出队最小值(最早结束的一个会议)
                if(meet[0] >= priorityQueue.peek()){
                    priorityQueue.poll();
                }
            }
            priorityQueue.add(meet[1]);
        }
        //最后优先队列中剩余元素数量就是需要的会议室数量
        System.out.println("需要会议室的数量为：" + priorityQueue.size());

    }
}
