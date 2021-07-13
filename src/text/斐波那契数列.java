package text;

import java.util.HashMap;

public class 斐波那契数列 {
    public static void main(String[] args) {

    }
    public int fib(int n) {
        int a=0;//f(n)
        int b=1;//f(n+1)
        int sum=0;//f(n+2)
        for(int i=0;i<n;i++){//迭代
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return sum;
    }

    HashMap<Integer,Integer> map=new HashMap();
    public int fib1(int n) {
        if(n<2){return n;}
        if(map.containsKey(n)){return map.get(n);}
        int res=(fib(n-1)+fib(n-2))%1000000007;
        map.put(n,res);//计算过的放在map中，后面直接取用
        return res;
    }
}
