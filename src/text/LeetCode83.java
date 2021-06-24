package text;

public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //快指针和慢指针，快指针是慢指针的下一个节点
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode tmp;
        while(fast!=null){
            tmp=fast.next;
            //快指针和慢指针的值相等，删除快指针位置的节点
            if(fast.val==slow.val){
                fast.next=null;
                slow.next=tmp;
                fast=tmp;
            } else{
                fast=fast.next;
                slow=slow.next;
            }
        }
        return head;
    }
}
