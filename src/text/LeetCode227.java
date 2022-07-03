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
    //不能遇到数字就进行计算,而是遇到下一个符号再把前面的符号和数字进行运算
    //因为数字可能不止一位,42 - 31 + 2如果一遇到4就进行运算那肯定是不行的 要到+号之后在计算42 - 31
    public int calculate(String s) {
        //默认第一个数一定是正数
        char preSign = '+';
        //num用来存储当前运算符前面的值，同时根据该值前面的运算符进行计算，然后再入栈
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            //如果是数字，先把数字放在num中，需要 - '0'
            if(Character.isDigit(s.charAt(i))){
                //这里如果是连续的几个数字，比如42，就需要把num * 10 之后 再加上当前的数字
                num = num * 10 + s.charAt(i) - '0';
            }
            //如果是运算符或者最后一个数字，需要根据preSign符号把num进行运算，然后把num入栈并且修改preSign
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '  || i == s.length() - 1){
                switch(preSign){
                    //+号，直接把num存入栈顶
                    case '+' :
                        stack.push(num);
                        break;
                    //-号，把-num存入栈顶
                    case '-' :
                        stack.push(-num);
                        break;
                    //*号，把栈顶元素和num进行*运算后，替换栈顶元素
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                    // /号，把栈顶元素和num进行/运算后，替换栈顶元素
                    case '/' :
                        stack.push(stack.pop() / num);
                        break;
                }
                //num的值根据preSign符号入栈完之后，把num置0，preSign变成当前的运算符
                num = 0;
                preSign = s.charAt(i);
            }
        }
        //用来存储最终结果，把栈中运算完的值依次加入result中即可
        int result = 0;
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }
}
