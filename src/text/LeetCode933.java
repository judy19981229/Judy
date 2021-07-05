package text;

import java.util.LinkedList;

public class LeetCode933 {
    public static void main(String[] args) {

    }

    class RecentCounter {
        LinkedList<Integer> queue;
        public RecentCounter() {
            queue=new LinkedList();
        }

        public int ping(int t) {
            queue.add(t);//队列中存放的是请求的时间
            while(queue.peek()< t-3000 ){//peek方法，取队列的头元素
                queue.poll();//把请求时间小于t-3000的出队
            }
            return queue.size();//队列的大小就是3000秒内的请求次数
        }
    }
}
