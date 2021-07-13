package text;

import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));//左括号就入栈
                    break;
                case ')'://如果栈顶元素不为(，则括号不匹配
                    if(stack.isEmpty() || stack.peek()!='('){return false;}
                    stack.pop();
                    break;
                case ']'://如果栈顶元素不为[，则括号不匹配
                    if(stack.isEmpty() || stack.peek()!='['){return false;}
                    stack.pop();
                    break;
                case '}'://如果栈顶元素不为{，则括号不匹配
                    if(stack.isEmpty() || stack.peek()!='{'){return false;}
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}
