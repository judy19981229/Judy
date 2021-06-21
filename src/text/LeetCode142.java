package text;

import java.util.HashSet;

public class LeetCode142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if(head==null){return null;}
        ListNode fast=head;
        ListNode slow=head;
        do{
            if(fast==null || fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        } while(slow!=fast);
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
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
