package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        //特殊情况
        if(head.next == null) return true;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        //通过快慢指针的方式，来反转前半边链表，快指针走到尾或者快指针为null，就说明已经反转了前半部分链表
        while(fast != null && fast.next != null){
            //快指针先走，再反转链表 pre->slow->tmp 变成 pre<-slow->tmp(slow指向pre)
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        //如果fast不为null，说明fast在最后一个节点，链表为奇数个，slow在中间节点
        //pre在中间节点前一个，slow要向后走一步，走到中间节点后一个
        if(fast != null) slow = slow.next;
        //pre往前遍历，slow往后遍历，如果值不相同，说明不对称
        while(pre != null && slow != null){
            if(pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        //pre和slow同时遍历完，说明对称
        return true;
    }
    public boolean isPalindromeStack(ListNode head) {
        //特殊情况
        if(head.next == null) return true;
        //栈存储链表节点，先进先出，就可以反向输出链表了
        Deque<ListNode> stack = new LinkedList<>();
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        tmp = stack.pop();
        //如果前后的val值相同，就一直遍历
        while(head.val == tmp.val){
            //如果头尾相遇，或者头下一个就是尾，那么说明是头尾完全对称的，返回true
            if(head == tmp || head.next == tmp) return true;
            head = head.next;
            tmp = stack.pop();
        }
        //如果头尾的值不相同了，那么头尾就不对称，返回false
        return false;
    }

}
