package text;

public class LeetCode138 {
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if(head==null){return head;}
        Node tmp=head;
        while(tmp!=null){//复制每一个节点并加在原先节点后面
            Node tmpHair=new Node(tmp.val);
            tmpHair.next=tmp.next;
            tmp.next=tmpHair;
            tmp=tmpHair.next;
        }
        tmp=head;
        while(tmp!=null){//把复制的节点的随机指针指向原先指向的下一个节点（复制的节点）
            tmp.next.random=(tmp.random!=null?tmp.random.next:null);
            tmp=tmp.next.next;
        }
        Node oldHair=head;
        Node newHair=head.next;
        Node hair=newHair;
        while(oldHair!=null){//把复制的节点拆出来，组成一个新的链表
            oldHair.next=oldHair.next.next;
            newHair.next=(newHair.next!=null?newHair.next.next:null);
            oldHair=oldHair.next;
            newHair=newHair.next;
        }
        return hair;
    }
}
