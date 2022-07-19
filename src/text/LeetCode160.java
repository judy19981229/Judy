package text;

import java.util.HashSet;
import java.util.Set;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //特殊情况
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        //双指针A和B，分别遍历headA和headB
        ListNode A = headA;
        ListNode B = headB;
        //A等于B时终止循环(重点是在A遍历完headA之后把A设置成headB，B同理)
        //如果headA和headB不相交，那么A和B最后都会遍历完headA和headB，同时走到null
        //如果headA和headB相交，那么A和B会在遍历完headA和headB，变成headB和headA之后，同时走到相交处
        //headA的长度为 m(a + c) headB的长度为n(b + c) a b为A和B走到相交处的距离，c为相交后面的距离
        //A会走 a + c + b(到相交处) B会走 b + c + a(到相交处)
        while(A != B){
            //A不为null就继续往后走，A为null就把A设置为headB
            A = (A != null ? A.next : headB);
            //B不为null就继续往后走，B为null就把B设置为headA
            B = (B != null ? B.next : headA);
        }
        //最后返回A(为null或者相交节点)
        return A;
    }
    //用Set集合
    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {
        //特殊情况
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        Set<ListNode> set = new HashSet<>();
        //先把headA中节点都放到set集合中
        while(headA != null ){
            set.add(headA);
            headA = headA.next;
        }
        //再把headB中节点都放到set集合中，如果有重复就返回当前节点(为相交节点)
        while(headB != null ){
            if(!set.add(headB)) return headB;
            headB = headB.next;
        }
        //如果headB都放到set集合中也没有重复，说明A B无相交节点
        return null;
    }
}
