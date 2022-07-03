package text;

public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        //两两合并
        /*
        ListNode res = null;
        for(ListNode node : lists){
            res = mergeTwo(res, node);
        }
        return res;
        */
        return merge(lists, 0, lists.length-1);
    }
    public ListNode merge(ListNode[] lists, int l, int r) {
        if(l == r) return lists[l];
        if(l > r) return null;
        int mid = (l + r) / 2;
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
    //合并两个链表的方法
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode hair = new ListNode(0);
        ListNode cur = hair;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;

        return hair.next;
    }
}
