package text;

public class LeetCode19 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair=new ListNode(0,head);
        ListNode con=hair;//删除节点的前一个节点con
        ListNode cur,tail;//删除节点cur，删除节点的下一个节点tail
        ListNode tmp=head;
        int length=1;//计算链表长度
        while(tmp.next!=null){
            tmp=tmp.next;
            length++;
        }
        int num=length-n;
        while(num>0){
            con=con.next;
            num--;
        }
        cur=con.next;
        tail=con.next.next;
        cur.next=null;//断开删除节点和下一个节点
        con.next=tail;//连上删除节点的前一个节点和下一个节点
        return hair.next;
    }
}
