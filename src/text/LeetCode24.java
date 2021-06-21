package text;

public class LeetCode24 {
    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){return head;}
        ListNode hair=new ListNode(0,head);
        ListNode con=hair;//翻转部分的前一个节点
        //ListNode head；翻转部分的第一个节点
        ListNode tail;//两两翻转的第二个节点
        ListNode tmp;//翻转部分的下一个节点
        while(head!=null){
            tail=head.next;
            if(tail==null){return hair.next;}
            tmp=tail.next;
            tail.next=head;//尾指向头
            head.next=tmp;//头指向尾的下一个
            con.next=tail;//头的前一个指向尾
            con=head;//头变成新的翻转部分的前一个
            head=tmp;//下一个变成新的翻转部分的头
        }
        return hair.next;
    }
}
