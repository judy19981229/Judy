package text;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode636 {
/*输入：n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
输出：[3,4]
解释：
函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，于时间戳 1 的末尾结束执行。
函数 1 在时间戳 2 的起始开始执行，执行 4 个单位时间，于时间戳 5 的末尾结束执行。
函数 0 在时间戳 6 的开始恢复执行，执行 1 个单位时间。
所以函数 0 总共执行 2 + 1 = 3 个单位时间，函数 1 总共执行 4 个单位时间。 */

    class task{
        int id;
        boolean isStart;
        int time;
        public task(String[] split) {
            id=Integer.parseInt(split[0]);
            isStart=split[1].equals("start");
            time=Integer.parseInt(split[2]);
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<task> stack=new LinkedList<>();
        int[] result=new int[n];
        for(String s:logs){
            task t=new task(s.split(":"));
            if(t.isStart){
                stack.push(t);
            }else{
                int time=t.time-stack.pop().time+1;
                result[t.id]+=time;
                if(!stack.isEmpty()){
                    result[stack.peek().id]-=time;
                }
            }
        }
        return result;
    }
}
