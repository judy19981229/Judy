package text;

import java.util.*;

public class LeetCode207 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Collections.max(list));;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //preNums表示学该门课之前需要学nums门课(如果已经学了一门课 nums就 - 1)
        Map<Integer, Integer> preNums = new HashMap<>();
        //numCourses门课程为0到numCourses - 1, 存入prenNms的key中, value先都设置为0
        for(int i = 0; i < numCourses; i++){
            preNums.put(i, 0);
        }
        //nextCourses用来存储每一门课程(key) 和 该课程是那哪些课程的前置课程-对应的后置课程(value)
        Map<Integer, List<Integer>> nextCourses = new HashMap<>();
        //[0, 1]表示 要学课程 0 先学课程1
        for(int[] prerequisity : prerequisites){
            //当前课程
            int cur = prerequisity[0];
            //前置课程
            int pre = prerequisity[1];
            //把当前课程 需要学习的前置课程数目 + 1
            preNums.put(cur, preNums.get(cur) + 1);
            //把前置课程 对应的当前课程 存入list集合中
            if(!nextCourses.containsKey(pre)){
                nextCourses.put(pre, new ArrayList<>());
            }
            nextCourses.get(pre).add(cur);
        }
        //先把所有不需要前置课程的课程存入队列中
        Deque<Integer> queue = new LinkedList<>();
        for(int key : preNums.keySet()){
            if(preNums.get(key) == 0){
                queue.add(key);
            }
        }
        //遍历队列，队列中存放的是所有不需要前置课程的课程、或者已经学完前置课程的课程
        while(!queue.isEmpty()){
            //当前课程
            int cur = queue.poll();
            //如果当前课程没有后置课程，直接继续遍历
            if(!nextCourses.containsKey(cur)){
                continue;
            }
            List<Integer> nexts = nextCourses.get(cur);
            for(int next : nexts){
                //把队列中的课程对应的后置课程需要的前置课程数 - 1
                preNums.put(next, preNums.get(next) - 1);
                //同时把学完前置课程的后置课程入队
                if(preNums.get(next) == 0){
                    queue.add(next);
                }
            }
        }
        //学完所有课程之后，如果还有课程的前置课程数没归0，说明不能完成所有课程的学习
        for(int key : preNums.keySet()){
            if(preNums.get(key) != 0){
                return false;
            }
        }
        //走到这说明都学完了，返回true
        return true;
    }

}

