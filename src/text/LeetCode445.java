package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1=new LinkedList<>();
        Deque<Integer> stack2=new LinkedList<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int change=0;//进位
        ListNode result=null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || change!=0){
            int a=stack1.isEmpty()?0:stack1.pop();
            int b=stack2.isEmpty()?0:stack2.pop();
            int num=a+b+change;
            change=num/10;
            num=num%10;
            ListNode tmp=new ListNode(num);//加完之后是7-0-8-7，需要输出7-8-0-7
            tmp.next=result;//把链表反着串起来，tmp始终是result的前一个节点
            result=tmp;// result变成tmp，开始下一次循环（tmp 7-0-8-7-null result 7-0-8-7）
        }
        return result;
    }
}
