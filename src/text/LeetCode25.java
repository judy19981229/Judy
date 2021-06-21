package text;

public class LeetCode25 {
    public static void main(String[] args) {
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair=new ListNode(0,head);
        ListNode con=hair;//con节点是反转部分的前一个节点
        //head节点是反转部分的第一个节点
        ListNode tail;//tail节点是反转部分的最后一个节点
        while(head!=null){
            tail=con;
            for(int i=0;i<k;i++){
                //通过k的值，找到反转部分的最后一个节点
                tail=tail.next;
                if(tail==null){ return hair.next; }
            }
            ListNode[] reverse=reverse(head,tail);
            head=reverse[0];//反转部分反转之后的头节点
            tail=reverse[1];//反转部分反转之后的尾节点
            //把前一个节点指向反转部分反转之后的头节点
            con.next=head;
            //con节点变成反转部分反转之后的尾节点（下一次反转的前一个节点）
            con=tail;
            //头节点指向反转部分反转之后的尾节点的下一个节点（下次反转的头节点）
            head=con.next;
        }
        return hair.next;
    }
    public ListNode[] reverse(ListNode head,ListNode tail){
        //pre先指向tail的下一个节点,让head直接指向pre
        //反转之后的head为尾节点，需要指向原先尾节点tail的下一个节点
        ListNode pre=tail.next;
        ListNode cur=head;
        ListNode tmp;
        while(pre!=tail){
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        //返回反转之后的新的头节点和尾节点
        return new ListNode[] {tail,head};
    }

}
