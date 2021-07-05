package text;

public class LeetCode859 {
    public static void main(String[] args) {
        System.out.println('b'-'a');//1
        System.out.println("abc".charAt(0));//a
        System.out.println("abc".charAt(1));//b
        System.out.println("abc".charAt(2));//c
    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){return false;}//长度不同，直接返回false
        else if(s.equals(goal)){
            int [] count=new int[26];//用来存储a-z的个数
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;//'a'-'a'=0
                if(count[s.charAt(i)-'a']>1){return true;}//两个以上相同的，可以交换
            }
            return false;
        }else{
            int first=-1;
            int second=-1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=goal.charAt(i)){
                    if(first==-1){first=i;}
                    else if(second==-1){second=i;}
                    else{return false;}//有三个不相同的位，直接返回false
                }
            }//second不为-1，说明有两位不相同
            return (second!=-1 && s.charAt(first)==goal.charAt(second) &&
                    s.charAt(second)==goal.charAt(first) );
        }
    }
}
