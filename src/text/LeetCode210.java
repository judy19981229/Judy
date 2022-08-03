package text;

import java.util.*;

public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //当前课程需要学习的前置课程数目
        Map<Integer, Integer> preNums = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            preNums.put(i, 0);
        }
        //当前课程对应的后置课程集合
        Map<Integer, List<Integer>> nextCourses = new HashMap<>();
        //遍历获取当前课程，和它要求的前置课程
        for(int[] course : prerequisites){
            int cur = course[0];
            int pre = course[1];
            //当前课程要求前置课程 + 1
            preNums.put(cur, preNums.get(cur) + 1);
            //前置课程对应的后置课程集合中放入当前课程
            if(!nextCourses.containsKey(pre)){
                nextCourses.put(pre, new ArrayList<>());
            }
            nextCourses.get(pre).add(cur);
        }
        //队列存放的是不需要前置课程的课程，和已经学完所有前置课程的课程
        Deque<Integer> queue = new LinkedList<>();
        //先把所有不需要前置课程的课程放入队列中
        for(int key : preNums.keySet()){
            if(preNums.get(key) == 0){
                queue.add(key);
            }
        }
        //结果集合，以及用来存放课程的下标
        int[] result = new int[numCourses];
        int count = 0;
        //遍历队列
        while(!queue.isEmpty()){
            //获取并出队队首课程（最开始是不需要前置课程的课程，后面是学完前置课程的课程）
            int cur = queue.poll();
            //存入结果集中
            result[count++] = cur;
            //如果没有后置课程，继续循环
            if(!nextCourses.containsKey(cur)){
                continue;
            }
            //遍历后置课程
            List<Integer> courses = nextCourses.get(cur);
            for(int course : courses){
                //更改后置课程需要的前置课程数 即进行- 1操作
                preNums.put(course, preNums.get(course) - 1);
                //同时把已经学完所有前置课程的后置课程入队
                if(preNums.get(course) == 0){
                    queue.add(course);
                }
            }
        }
        //如果有课程的前置课程数没减少到0，说明没法学完
        for(int key : preNums.keySet()){
            if(preNums.get(key) != 0){
                return new int[0];
            }
        }
        //可以学完，返回result
        return result;
    }
}
