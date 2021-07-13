package text;

public class LeetCode779 {
    public static void main(String[] args) {

    }
    //奇数：和上一行相同；偶数：和上一行相反
    public int kthGrammar(int n, int k) {
        if(n==0){return 0;}//第一行只能是0
        if(k%2==1){//是奇数
            return kthGrammar(n-1,(k+1)/2);
        }else{//是偶数
            return Math.abs(kthGrammar(n-1,k/2)-1);
        }
    }
}
