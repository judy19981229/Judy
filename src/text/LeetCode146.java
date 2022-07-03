package text;

import java.util.HashMap;

public class LeetCode146 {

    //一、自定义节点类[【本题唯一需要的数据结构就是Node】]
    class Node{
        public int key , val;
        public Node next , prev;//双向指针:next表示下一个，prev表示前一个
        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

    //二、自定义双向链表
    class DoubleList{
        //并非真的需要链表List数据结构,只需要将节点Node前后的方向对应好就可以实现双向链表的效果
        private Node head , tail;//head是头节点，tail是尾节点
        private int size;
        //在链表头部添加节点，及时更新头节点head和size
        public void addFirst(Node node){
            if(head == null){
                head = tail = node;
            }else{
                //将head与node变换位置，使得node在前，head在后，即node→head
                Node n = head;
                n.prev = node;//在头结点head之前
                node.next = n;
                //交换之后要及时更新头节点head
                head = node;
            }
            size++;
        }
        //删除链表中的x节点（x一定存在），及时更新尾节点tail、头节点head和size
        public void remove(Node node){
            //需要讨论node在链表中的位置
            if(head == node && tail == node){
                head = null;
                tail = null;
            }else if(tail == node){
                node.prev.next = null;//删除node节点
                tail = node.prev;//更新尾部节点
            }else if(head == node){
                node.next.prev = null;//删除
                head = node.next;//更新
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
        //删除链表中最后一个节点，并返回该节点
        public Node removeLast(){
            Node node = tail;
            remove(tail);
            return node;
        }
        //返回链表长度
        public int size(){
            return size;
        }
    }

    //三、实现满足LRU缓存的数据结构
    class LRUCache {
        //使用哈希表存放key,Node(key,val)，实现快速查找、插入、删除
        private HashMap<Integer , Node> map;
        //使用自定义双向链表实现最久未使用（垃圾）的关键字的删除，即垃圾回收，将垃圾（最久未使用的元素）放在链表尾部（删除尾部元素），最新使用的放在头部（在头部插入）
        private DoubleList cache;
        private int cap;//最大容量
        //以 正整数 作为容量 capacity 初始化 LRU 缓存
        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();//哈希表初始化
            cache = new DoubleList();//双向链表初始化
        }
        //查找
        public int get(int key) {
            //如果不存在，返回-1
            if(!map.containsKey(key)){
                return -1;
            }
            int val = map.get(key).val;
            //将查找的元素(key,val)提前至头部
            put(key , val);
            //如果存在，返回key的value值
            return val;
        }
        //插入或更改
        public void put(int key, int value) {
            Node x = new Node(key , value);
            //如果存在则更改
            if(map.containsKey(key)){
                //在双向链表中删除旧的节点
                cache.remove(map.get(key));
                //在双向链表头部插入新的节点
                cache.addFirst(x);
                //更新哈希表map中的数据
                map.put(key , x);
            }else{
                //如果不存在则插入
                //插入时先判断容量是否够用
                //如果容易已满，则先删除垃圾（链表尾部元素）
                if(cap == cache.size()){
                    Node last = cache.removeLast();//返回并删除尾部元素
                    map.remove(last.key);
                }
                //，再去插入新元素
                cache.addFirst(x);
                map.put(key , x);
            }


        }
    }
}


