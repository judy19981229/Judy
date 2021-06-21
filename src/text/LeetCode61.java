package text;

public class LeetCode61 {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){return head;}
        ListNode oldTail=head;//找链表原先的尾节点
        int length=1;//找链表的长度
        while(oldTail.next!=null){
            oldTail=oldTail.next;
            length++;
        }
        oldTail.next=head;//把链表尾节点指向头节点
        int num=length-(k%length)-1;//找到新的尾节点需要向后走num步
        ListNode newTail=head;
        while(num>0){
            newTail=newTail.next;
            num--;
        }
        ListNode con=newTail.next;//找到新的头节点
        newTail.next=null;//新的尾节点和头节点
        return con;
    }
}
