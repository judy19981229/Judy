package text;

public class 剑指offer22倒数第k个节点 {

    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode tmp=head;
        int count=1;
        while(tmp.next!=null){
            count++;
            tmp=tmp.next;
        }
        int num=count-k;
        while(num>0){
            head=head.next;
            num--;
        }
        return head;
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first=head;
        ListNode second=head;
        for(int i=0;i<k;i++){
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }
}
