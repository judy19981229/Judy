package text;

public class LeetCode622 {

}

class MyCircularQueue {
    int[] queue;//队列数组
    int front;//队列头指针(出队元素的位置)
    int rear;//队列尾指针(入队元素的位置)
    int capacity;//队列长度
    int count;//队列中的元素数量
    public MyCircularQueue(int k) {
        queue=new int[k];
        front=0;
        rear=0;
        capacity=k;
        count=0;
    }

    public boolean enQueue(int value) {//入队
        if(isFull()){return false;}
        queue[rear]=value;
        rear=(rear+1)%capacity;
        count++;
        return true;
    }

    public boolean deQueue() {//出队
        if(isEmpty()){return false;}
        front=(front+1)%capacity;
        count--;
        return true;
    }

    public int Front() {//队首元素
        if(isEmpty()){return -1;}
        return queue[front%capacity];
    }

    public int Rear() {//队尾元素
        if(isEmpty()){return -1;}
        return queue[(rear-1+capacity)%capacity];
    }

    public boolean isEmpty() {//判空
        return count==0;
    }

    public boolean isFull() {//判满
        return count==capacity;
    }


}
