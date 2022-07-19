package text;

import java.util.*;

public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        //特殊情况
        if(head == null || head.next == null) return head;
        ListNode tmp = head;
        //把链表所有节点放在数组中
        List<ListNode> list = new ArrayList<>();
        while(tmp != null){
            list.add(tmp);
            tmp = tmp.next;
        }
        //把数组按照链表节点的val值进行排序
        //用到Collections.sort方法，如果里面是int类型的，直接排序即可
        //不是int类型的需要实现Comparator接口，重写compare方法，返回值是int
        //返回l1.val - l2.val表明l1 > l2时返回正数 (按照升序排序)
        //返回l2.val - l1.val表明L1 < l2时返回正数 (按照降序排序)
        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        //把链表重新串起来
        tmp = list.get(0);
        head = tmp;
        for(int i = 1; i < list.size(); i++){
            tmp.next = list.get(i);
            tmp = tmp.next;
        }
        //链表最后一个节点指向null，不然链表有环
        tmp.next = null;
        return head;
    }
}

