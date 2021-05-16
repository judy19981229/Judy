package text;

public class Reverse {
    public static void main(String[] args) {
        Node head=new Node(0);
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        //打印
        Node h=head;
        while(null!=h){
            System.out.print(h.getData()+" ");
            h=h.getNext();
        }
        System.out.println();
        System.out.println("- - - -");
        head=reverse(head);
        while(null!=head){
            System.out.print(head.getData()+" ");
            head=head.getNext();
        }
    }

    private static Node reverse(Node head) {
        if(head==null){return head;}
        Node pre=head; //当前节点
        Node cur=head.getNext();//下一个节点
        Node tmp; //临时节点
        while(cur!=null){//下一个节点为空说明是尾节点
            //临时节点是下一个节点原先指向的下一个节点
            tmp=cur.getNext();
            cur.setNext(pre);

            pre=cur;
            cur=tmp;
        }
        head.setNext(null);
        return pre;
    }

    static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
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
}
