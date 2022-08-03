package text;

public class LeetCode138 {
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        //在原先的每个节点后面复制一个相同的节点 1 2 3 -> 1 1 2 2 3 3
        Node tmp = head;
        while(tmp != null){
            //复制copy之后放到tmp后面
            Node copy = new Node(tmp.val);
            copy.next = tmp.next;
            tmp.next = copy;
            //这里进入下次循环，tmp = tmp.next.next （因为tmp.next = copy)
            tmp = copy.next;
        }
        tmp = head;
        //复制的节点的随机指针也指向复制后的节点
        // 1 2 1的随机指针指向2 那么 1 1 2 2 复制之后 复制的1指向复制的2
        while(tmp != null){
            //这里需要判空 tmp.random != null 不然会空指针异常
            if(tmp.random != null){
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        //断开链表，返回复制后的部分
        Node hair = new Node(0);
        tmp = head;
        Node cur = hair;
        while(tmp != null){
            cur.next = tmp.next;
            cur = cur.next;
            tmp.next = cur.next;
            tmp = tmp.next;
        }
        return hair.next;
    }
}
