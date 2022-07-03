package text;

public class LeetCode707 {

    class MyLinkedList {
        int count;
        ListNode head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            count=0;
            head=new ListNode(0);//head是一个虚拟头节点
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index>=count || index<0){return -1;}
            ListNode tmp=head;
            while(index-->=0 && tmp.next!=null){
                tmp=tmp.next;
            }
            return tmp.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            addAtIndex(count,val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            ListNode cur=head;
            if(index>count){return;}
            else if(index<=0){
                ListNode tmp=head.next;
                head.next=new ListNode(val);
                head.next.next=tmp;
            }
            else if(index==count){
                while(cur.next!=null){
                    cur=cur.next;
                }
                cur.next=new ListNode(val);
            }
            else {
                while(index-->0 && cur.next!=null){
                    cur=cur.next;
                }
                ListNode tmp=cur.next;
                cur.next=new ListNode(val);
                cur.next.next=tmp;
            }
            count+=1;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index>=count || index<0){return;}
            ListNode cur=head;
            while(index-->0 &&cur.next!=null){
                cur=cur.next;
            }
            ListNode tmp=cur.next;
            if(tmp!=null){cur.next=tmp.next;}
            else{cur.next=null;}
            count-=1;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
