package text;

public class LeetCode1021 {
    public static void main(String[] args) {
    }
/*
输入：s = "(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
*/
    public static String removeOuterParentheses(String s) {
        StringBuffer result=new StringBuffer();
        //count记录左右括号的差值，pre用来找到最外层括号的起始位置
        for(int i=0,count=0,pre=0;i<s.length();i++){
            if(s.charAt(i)=='('){count++;}
            else{count--;}
            if(count!=0){continue;}//找到count为0的位置（最外层括号的结束位置）
            result.append(s.substring(pre+1,i+1-1));
            //substring方法是左闭右开的[pre+1,i),这样刚好可以去掉外层括号
            pre=i+1;//i+1是下一次最外层括号的起始位置
        }
        return result.toString();
    }
}
