package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode32 {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        //通过栈来存储(的下标,同时存储(前面一个无效的)的下标来充当标志位，来计算出有效括号的长度
        Deque<Integer> stack = new LinkedList<>();
        //需要先给栈存入一个-1，用来当作第一个无效的)，
        stack.push(-1);
        //用来保存最长有效括号，需要用到Math.max()方法进行对比
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            //如果遇到'('，直接入栈左括号的下标
            if(cur == '('){
                stack.push(i);
            }
            //如果遇到')'，直接出栈当前栈顶元素（因为已经预存了一个-1，所以即使第一个就是')'也不会为空栈
            else if(cur == ')'){
                stack.pop();
                //如果栈不为空，就说明还有匹配的左括号
                if(!stack.isEmpty()){
                    //每匹配一次右括号，都要比较一下最大值（匹配成功就是有效的括号）
                    //最大值应该是之前的最大值和当前的下标值i - 当前栈顶的下标值（
                    //栈顶可能是前面的(，也可能是前面一个无效的)
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
                //如果栈为空，就需要把当前右括号存入栈中，当作前面一个不匹配的")"
                else{
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}
