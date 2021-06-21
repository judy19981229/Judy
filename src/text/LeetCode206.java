package text;

import java.util.List;

public class LeetCode206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode tmp;
        while(cur!=null){
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre ;
    }

    private static ListNode reverseList1(ListNode head) {
        if(head==null){return head;}
        ListNode pre=head; //当前节点
        ListNode cur=head.next;//下一个节点
        ListNode tmp; //临时节点
        while(cur!=null){//下一个节点为空说明是尾节点
            //临时节点是下一个节点原先指向的下一个节点
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        head.next=null;
        return pre;
    }

}
