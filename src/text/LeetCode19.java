package text;

public class LeetCode19 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟头节点，防止要删除头节点
        ListNode hair = new ListNode(0, head);
        ListNode fast = head;
        //慢指针指向虚拟头节点，这样快指针走到null的时候，慢指针就是要删除节点的前一个节点
        ListNode slow = hair;
        //快指针先走n步
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return hair.next;
    }
}
