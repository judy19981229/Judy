package text;

import java.util.Stack;

public class LeetCode面试题两个栈实现队列 {

    class MyQueue{
        Stack<Integer> inStack;//用来入队的栈
        Stack<Integer> outStack;//用来出队的栈
        /** Initialize your data structure here. */
        public MyQueue() {
            inStack=new Stack();
            outStack=new Stack();
        }
        //把入队的栈中的元素出栈到出队的栈中
        public void move(){
            if(!outStack.isEmpty()){ return;}
            //出队的栈如果为空，就需要把入队的栈中的元素导入出队的栈中
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        /** Push element x to the back of queue. */
        public void push(int x) {//入队，入到inStack中
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {//出队，从outStack中出
            move();
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            move();
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return (inStack.isEmpty() && outStack.isEmpty());
        }
    }
}
