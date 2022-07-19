package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode155 {
    class MinStack {
        //双栈实现
        Deque<Integer> stack;
        //最小栈，记录当前元素入栈后栈内最小值,每次出栈当前元素不影响栈内其他元素找最小值
        Deque<Integer> minStack;
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            //最小栈为空时不比较，直接入栈
            if(minStack.isEmpty()) minStack.push(val);
            else minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
