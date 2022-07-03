package text;

public class sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if(x<=1){return x;}
        int l = 1 ;
        int r = x ;
        int res = -1 ;
        while(l<=r){
            int mid = l+(r-l)/2 ;
            if((long)mid*mid <= x){
                res = mid ;
                l = mid+1 ;
            }else{
                r = mid-1 ;
            }
        }
        return res;
    }

}
