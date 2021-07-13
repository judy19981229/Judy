package text;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode1249 {
    public static void main(String[] args) {

    }

    public String minRemoveToMakeValid(String s) {
        StringBuffer result=new StringBuffer(s);//Queue来实现队列
        //Deque<Integer> stack=new LinkedList<>();Deque来实现栈，栈中存放的是括号的下标
        Stack<Integer> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);//为'('时入栈'('的下标
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty()&&s.charAt(stack.peek())=='('){
                    //为')'时判断，栈不为空且栈顶下标对应的为'('时把'('的下标出栈
                    stack.pop();
                }else{//栈为空或者对应元素不为'('的下标时入栈
                    stack.push(i);
                }
            }
        }
        while(!stack.isEmpty()){//遍历栈中的下标来删除括号
            result.deleteCharAt(stack.pop());
        }
        /*for(Integer i:stack){
            result.deleteCharAt(i);//根据的下标来删除多余括号
        }*/
        return result.toString();
    }
}
