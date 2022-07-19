package text;

import java.util.Deque;
import java.util.LinkedList;

public class 剑指OfferII041 {
    class MovingAverage {
        int size;
        Deque<Integer> deque;
        double sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            deque = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if(deque.size() == size){
                sum -= deque.removeFirst();
            }
            deque.addLast(val);
            sum += val;
            return sum / deque.size();
        }
    }
}
