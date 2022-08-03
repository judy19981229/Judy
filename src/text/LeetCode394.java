package text;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class LeetCode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));

    }

    public static String decodeString(String s) {
        //双端队列存储字符串中每一位
        Deque<String> deque = new LinkedList<>();
        int count = 0;
        int i = 0;
        int length = s.length();
        while(i < length){
            char cur = s.charAt(i);
            //如果是数字，那么就要计算(有可能连续多位数字) char - '0' -> int  (char)(int + '0') -> char
            if(cur >= '0' && cur <= '9'){
                count = count * 10 + (cur - '0');
            }
            //如果是左括号，把前面的数字入栈(入栈后把count变为0 方便下次再计算数字)，再把左括号入栈
            else if(cur == '['){
                deque.addLast(String.valueOf(count));
                count = 0;
                deque.addLast(String.valueOf(cur));
            }
            //如果是字母，直接入栈
            else if(cur >= 'a' && cur <= 'z'){
                deque.addLast(String.valueOf(cur));
            }
            //如果是右括号
            else if(cur == ']'){
                //一个双端队列接收从右括号到左括号直接的字母
                Deque<String> dq = new LinkedList<>();
                while( !"[".equals(deque.getLast())){
                    dq.addFirst(deque.removeLast());
                }
                //出队前面的左括号
                deque.removeLast();
                //出队前面的数字
                int times = Integer.parseInt(deque.removeLast());
                StringBuilder tmp = new StringBuilder();
                //把左右括号中间所有字母倒入StringBuilder中
                while(!dq.isEmpty()){
                    tmp.append(dq.removeFirst());
                }
                //把StringBuilder根据数字个数加入栈中
                while(times-- > 0){
                    deque.addLast(tmp.toString());
                }
            }
            i++;
        }
        //把字符串从双端队列中输出到StringBuilder中
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

}
