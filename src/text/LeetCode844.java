package text;

import java.util.Stack;

public class LeetCode844 {
    public static void main(String[] args) {

    }
/*
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
# 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。
输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
*/
    public boolean backspaceCompare(String s, String t) {
        Stack<String> S= new Stack();
        Stack<String> T= new Stack();
        move(s, S);//把字符串变成栈
        move(t, T);
        if(S.size()!=T.size()){
            return false;//S和T栈的长度不相等，一定不相等
        }
        while(!S.isEmpty()){//遍历栈中的元素判断是否相等
            if (S.pop()!=T.pop()){
                return false;//栈顶元素不相等，一定不相等
            }
        }
        return true;
    }
    public void move(String s,Stack S){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(!S.isEmpty()){
                    S.pop();
                }
            }else{
                S.push(s.charAt(i));
            }
        }
    }
}
