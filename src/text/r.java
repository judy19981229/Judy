package text;

public class r {
    public static void main(String[] args) {
        Node head=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        Node h=head;
        while(h!=null){
            System.out.print(h.getData()+" ");
            h=h.getNext();
        }
        System.out.println();
        System.out.println("- - - -");
        Node h1=Reverse(head);
        while(h1!=null){
            System.out.print(h1.getData()+" ");
            h1=h1.getNext();
        }
    }
    public static Node Reverse(Node head){
        Node pre=head;
        Node cur=head.getNext();
        Node tmp;
        while(cur!=null){
            tmp=cur.getNext();
            cur.setNext(pre);
            pre=cur;
            cur=tmp;
        }
        head.setNext(null);
        return pre;
    }
}

class Node{
    int data;
    Node next;

     public Node(int data) {
         this.data = data;
     }

     public Node() {
     }

     public int getData() {
         return data;
     }

     public void setData(int data) {
         this.data = data;
     }

     public Node getNext() {
         return next;
     }

     public void setNext(Node next) {
         this.next = next;
     }
 }
