package text;

import java.util.Stack;

public class LeetCode946 {
    public static void main(String[] args) {

    }
/*
示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
*/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        //遍历，j为pushed的下标，i为popped的下标，找到和i位置出栈元素相等的pushed中的j位置元素
        for(int i=0,j=0;i<popped.length;i++){
            while(j< pushed.length&&(s.isEmpty()||s.peek()!=popped[i])){
                s.push(pushed[j]);
                j++;
            }
            //如果在popped中找不到和栈顶元素相同的可以出栈的元素，直接返回false
            if(s.peek()!=popped[i]){return false;}
            s.pop();
        }
        return true;
    }
}
