package text;

public class LeetCode92 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode l=reserve(l2,3);
        while(null!=l){
            System.out.print(l.val+" ");
            l=l.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int num=right-left+1;
        ListNode hair=new ListNode(0,head); //虚拟节点，下一个节点指向head
        ListNode con=hair;
        while(left>1){
            con=con.next;
            left--;
        }
        con.next=reserve(con.next,num);
        //反转之后把反转部分的前一个节点指向反转之后的一个节点（原先的最后一个节点）
        return hair.next;
    }
    public static ListNode reserve(ListNode head,int num){
        ListNode pre=null;
        ListNode cur=head;
        ListNode tmp;
        while(num>0){
            tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
            num--;
        }
        head.next=cur;
        //反转之后把反转部分的头节点指向原先尾节点的下一个节点
        return pre;
    }
}
