package text;

public class 剑指Offer35复杂链表的复制 {

    public Node copyRandomList(Node head) {
        if(head==null){return null;}
        Node tmp=head;
        while(tmp!=null){
            Node tmpHair=new Node(tmp.val);
            tmpHair.next=tmp.next;
            tmp.next=tmpHair;
            tmp=tmpHair.next;
        }
        tmp=head;
        while(tmp!=null){
            tmp.next.random=(tmp.random!=null?tmp.random.next:null);
            tmp=tmp.next.next;
        }
        Node oldHair=head;
        Node newHair=head.next;
        Node hair=newHair;
        while(newHair!=null){
            oldHair.next=oldHair.next.next;
            newHair.next=newHair.next!=null?newHair.next.next:null;
            oldHair=oldHair.next;
            newHair=newHair.next;
        }
        return hair;
    }
}
