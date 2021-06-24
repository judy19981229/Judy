package text;

public class LeetCode86 {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);//小链表，存放比x小的值
        ListNode smallHair=small;
        ListNode big=new ListNode(0);//大链表，存放比x大的值
        ListNode bigHair=big;
        ListNode cur=head;//用来遍历head的节点
        while(cur!=null){
            if(cur.val<x){
                small.next=cur;
                small=small.next;
            } else{
                big.next=cur;
                big=big.next;
            }
            cur=cur.next;
        }
        big.next=null;//大链表最后断开，不然会有环
        small.next=bigHair.next;//小链表尾指向大链表头
        return smallHair.next;
    }
}
