package text;

public class LeetCode82 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode hair=new ListNode(0,head);
        ListNode con=hair;//前一个节点
        ListNode cur=head;//当前节点
        ListNode tmp;//当前节点下一个节点
        while(cur!=null){
            tmp=cur.next;
            while(tmp!=null && cur.val==tmp.val){
                cur=cur.next;//找出重复部分的最后一个节点和下一个节点
                tmp=tmp.next;
            }
            if(con.next==cur){//如果没有重复，直接后移
                con=con.next;
                cur=cur.next;
            }else{
                con.next=tmp;//有重复，前一个节点直接指向重复部分最后一个节点的下一个节点
                cur=tmp;//把当前节点变成重复部分最后一个节点的下一个节点
            }
        }
        return hair.next;
    }
}
