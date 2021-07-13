package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode227 {
    public static void main(String[] args) {
        int num=0;
        for(int i=0;i<3;i++){
            num=num*10+"123".charAt(i)-'0';
        }
        System.out.println(num);
        System.out.println("是数字"+Character.isDigit("123".charAt(1)));
    }
    //输入：s = "3+2*2"输出：7
    public int calculate(String s) {
        char preSign='+';
        Deque<Integer> stack=new LinkedList<>();
        int num=0;//需要进行计算的数字
        int sum=0;//计算最后的结果
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){//如果是数字的话
                num=num*10+s.charAt(i)-'0';//s.charAt(i)-0之后才会转换成数字
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' '|| i==s.length()-1){
                switch (preSign){
                    case '+': stack.push(num);break;
                    case '-': stack.push(-num);break;
                    case '*': stack.push(stack.pop()*num);break;
                    case '/': stack.push(stack.pop()/num);break;
                }
                num=0;
                preSign=s.charAt(i);
            }
        }
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
