package text;

import java.util.Stack;

public class LeetCode682 {
    public static void main(String[] args) {

    }
/*
你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，
* ops 遵循下述规则：
整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。
*/
    public int calPoints(String[] ops) {
        Stack<Integer> count = new Stack();//一个栈来存放分数
        for(String op:ops) {
            if(op.equals("+")) {
                int a=count.pop();//先把最上面的分数保存起来，出栈后才能获得下面的分数
                int b=a+count.peek();//获得相加后的分数
                count.push(a);//把原先最上面的分数重新入栈
                count.push(b);//把相加后的分数入栈
            }else if(op.equals("D")){
                count.push(2*count.peek());
            }else if(op.equals("C")){
                count.pop();
            }else{//传入的是一个数字
                count.push(Integer.parseInt(op));//Integer.parseInt("把字符串变成数字")
            }
        }
        int sum=0;//这里也可以用for（Integer num：count）的方式来获得总分
        while(!count.isEmpty()){
            sum+=count.pop();
        }
        return sum;
    }
}

