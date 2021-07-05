package text;

import java.util.LinkedList;

public class LeetCode1670 {

}

class FrontMiddleBackQueue {
    class Node{//双向链表
        Node pre;//前一个节点
        Node next;//下一个节点
        int val;

        public Node() {
        }
        public Node(int val) {
            this.val = val;
        }

        public void insertPre(Node node){//在当前节点前面插入节点
            node.pre=this.pre;
            node.next=this;
            if(this.pre!=null){this.pre.next=node;}
            this.pre=node;
        }
        public void insertNext(Node node){//在当前节点后面插入节点
            node.pre=this;
            node.next=this.next;
            if(this.next!=null){this.next.pre=node;}
            this.next=node;
        }
        public void deletePre(){//删除当前节点前面节点
            if(this.pre==null) return;
            Node tmp=this.pre;
            this.pre=tmp.pre;
            if(tmp.pre!=null){tmp.pre.next=this;}
        }
        public void deleteNext(){//删除当前节点后面节点
            if(this.next==null) return;
            Node tmp=this.next;
            this.next=tmp.next;
            if(tmp.next!=null){tmp.next.pre=this;}
        }
    }
    class MyQueue{//队列在头和尾中间，如果头的下一个是尾就是队列为空
        Node head;//头
        Node tail;//尾
        int count;

        public MyQueue(){
            head=new Node();
            tail=new Node();
            head.pre=null;
            head.next=tail;
            tail.pre=head;
            tail.next=null;
            count=0;
        }

        public void pushFront(int value){//队列前面入队
            head.insertNext(new Node(value));
            count++;
        }
        public void pushBack(int value){//队列后面出队
            tail.insertPre(new Node(value));
            count++;
        }
        public int popFront(){//队列前面出队
            if(isEmpty()){return -1;}
            int val= head.next.val;
            head.deleteNext();
            count--;
            return val;
        }
        public int popBack(){//队列后面出队
            if(isEmpty()) {return -1;}
            int val=tail.pre.val;
            tail.deletePre();
            count--;
            return val;
        }
        public boolean isEmpty(){//为空
            return head.next==tail;
        }
        public int size(){//队列大小
            return count;
        }
    }
    MyQueue left;
    MyQueue right;
    public FrontMiddleBackQueue() {
        left=new MyQueue();
        right=new MyQueue();
    }

    public void reBalance(){//平衡，保证左边队列始终比右边大
        if(left.size()<right.size()){
            left.pushBack(right.popFront());
        }
        if(left.size()==right.size()+2){
            right.pushFront(left.popBack());
        }
    }

    public void pushFront(int val) {//左边队列入队
        left.pushFront(val);
        reBalance();
    }

    public void pushMiddle(int val) {//中间入队
        if(left.size()>right.size()){
            right.pushFront(left.popBack());
        }
        left.pushBack(val);
    }

    public void pushBack(int val) {//右边队列入队
        right.pushBack(val);
        reBalance();
    }

    public int popFront() {//左边队列出队
        if(isEmpty()){return -1;}
        int val=left.popFront();
        reBalance();
        return val;
    }

    public int popMiddle() {//中间队列出队
        if(isEmpty()){return -1;}
        int val=left.popBack();
        reBalance();
        return val;
    }

    public int popBack() {//右边队列出队
        if(isEmpty()){return -1;}
        int val;
        if(right.isEmpty()){
            val=left.popBack();
        }else{
            val=right.popBack();
        }
        reBalance();
        return val;
    }

    public boolean isEmpty(){//判空
        return left.size()==0;
    }
}

class FrontMiddleBackQueue1 {
    LinkedList<Integer> left;
    LinkedList<Integer> right;
    public FrontMiddleBackQueue1() {
        left=new LinkedList();
        right=new LinkedList();
    }
    public void reBalance(){
        if(left.size()<right.size()){
            left.addLast(right.pollFirst());
        }
        if(left.size()== right.size()+2){
            right.addFirst(left.pollLast());
        }
    }
    public void pushFront(int val) {
        left.addFirst(val);
        reBalance();
    }

    public void pushMiddle(int val) {
        if(left.size()>right.size()){
            right.addFirst(left.pollLast());
        }
        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
        reBalance();
    }

    public int popFront() {
        if(isEmpty()){return -1;}
        int val=left.removeFirst();
        reBalance();
        return val;
    }

    public int popMiddle() {
        if(isEmpty()){return -1;}
        int val=left.removeLast();
        reBalance();
        return val;
    }

    public int popBack() {
        if(isEmpty()){return -1;}
        int val;
        if(right.isEmpty()){
            val=left.removeLast();
        }else{
            val=right.removeLast();
        }
        reBalance();
        return val;
    }
    public boolean isEmpty(){
        return left.size()==0;
    }
}
