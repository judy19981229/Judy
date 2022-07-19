package text;

import java.util.HashSet;
import java.util.List;

public class LeetCode141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        //特殊情况
        if(head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow ){
            if(fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set=new HashSet();
        while(head!=null){
            if(!set.add(head)){
                return false;
            }
            head=head.next;
        }
        return true;
    }


}
