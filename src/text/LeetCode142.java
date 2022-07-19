package text;

import java.util.HashSet;

public class LeetCode142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        //如果head为空，或者head下一个节点为空，说明无环，返回null
        if(head == null || head.next == null) return null;
        //快慢指针判断链表是否有环
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null) {
            //先移动fast(两步)和slow(一步),然后再判断是否相遇
            fast = fast.next.next;
            slow = slow.next;
            //如果快慢指针相遇，说明有环了
            if(slow == fast){
                //快指针放到链表头部
                fast = head;
                //找到下一次快慢指针相遇的位置，就是环的入口
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        //到这说明链表无环
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set=new HashSet();
        while(head!=null){
            if(!set.add(head)){
                return head;
            }
            head=head.next;
        }
        return null;
    }

}
