package text;

import java.util.List;

public class LeetCode206 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){return head;}
        ListNode pre=null; //前一个节点
        ListNode cur=head;//当前节点
        ListNode tmp; //临时节点(当前节点下一个节点)
        while(cur!=null){//当前节点不为空
            //临时节点是当前节点下一个节点
            tmp=cur.next;
            //当前节点指向前一个节点(反转)
            cur.next=pre;
            //前一个节点和当前节点向后挪一步
            pre=cur;
            cur=tmp;
        }
        head.next=null;
        return pre;
    }

}
