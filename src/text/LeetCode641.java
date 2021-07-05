package text;

public class LeetCode641 {


}
class MyCircularDeque {
    int [] queue;//队列
    int front;//队列头指针（出队位置）
    int rear;//队列尾指针（入队位置）
    int capacity;//队列长度
    int count;//队列中元素数量
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue=new int[k];
        front=0;
        rear=0;
        capacity=k;
        count=0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {//队首入队
        if(isFull()){return false;}
        front=(front-1+capacity)%capacity;
        queue[front]=value;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {//队尾入队
        if(isFull()){return false;}
        queue[rear]=value;
        rear=(rear+1)%capacity;
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {//队首出队
        if(isEmpty()){return false;}
        front=(front+1)%capacity;
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {//队尾出队
        if(isEmpty()){return false;}
        rear=(rear-1+capacity)%capacity;
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){return -1;}
        return queue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){return -1;}
        return queue[(rear-1+capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count==capacity;
    }
}
