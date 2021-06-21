package text;

public class LeetCode202 {
    public static void main(String[] args) {

    }
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        do {
           if(fast==1 || getNext(fast)==1){
               return true;
           }
           fast=getNext(getNext(fast));
           slow=getNext(slow);
        } while(fast!=slow);
        return false;
    }
    int getNext(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }

}
