package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode143 {
    //1->n->2->n-1->3->n-2->...
/*
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
*/
    public void reorderList(ListNode head) {
        Deque<ListNode> deque=new LinkedList();
        ListNode cur=head;
        while(cur!=null){
            deque.add(cur);
            cur=cur.next;
        }
        while(!deque.isEmpty()){//双端队列，头连尾，头出队，尾连新队头，尾出队
            if(deque.size()==1 || deque.size()==2){//如果只剩下1个或者2个元素，停止循环
                deque.getLast().next=null;//最后一个元素应该指向null，不然会有环
                break;
            }
            deque.pollFirst().next=deque.getLast();
            deque.pollLast().next=deque.getFirst();
        }
    }
}
