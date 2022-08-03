package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {

    public int[] dailyTemperaturesStack(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        //特殊情况
        if(length == 1) return result;
        //从倒数第二个开始往回遍历，因为倒数第一个一定是0(后面不会升高)
        for(int i = length - 2; i >= 0; i--){
            //如果后面一个温度就升高了，直接返回1
            if(temperatures[i + 1] > temperatures[i]){
                result[i] = 1;
            }
            //如果后面一个温度没升高
            else{ //temperatures[i + 1] <= temperatures[i]
                //如果后面一个温度没升高且后面也都不会再升高了result = 0，那么本次result也为0
                if(result[i + 1] == 0){
                    result[i] = 0;
                    continue;
                }
                //result[j] != 0 && temperatures[j] <= temperatures[i]
                int j = i + 1 + result[i + 1];
                //如果后面温度有升高的，那么就一直找升高后的温度再比较
                //条件为 温度一直升高 并且 升高后的温度 低于 当前温度
                while(result[j] != 0 && temperatures[j] <= temperatures[i]){
                    j = j + result[j];
                }
                //如果找到高于当前的温度
                if(temperatures[j] > temperatures[i]) result[i] = j - i;
                    //result[j] == 0 && temperatures[j] <= temperatures[i]
                    //如果温度不升高 并且找到的最高温度低于当前温度
                else result[i] = 0;
            }
        }
        return result;
    }
}
