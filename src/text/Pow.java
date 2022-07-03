package text;

public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000,-2147483648) );
    }

    public static double myPow(double x, int n) {
        if(n == 0 ){ return 1.0; }
        return n>0 ? pow(x,n) : 1.0/pow(x,-n);
    }
    public static double pow(double x , int n) {
        if( n == 0 ) {return 1.0 ;}
        double y = pow(x,n/2) ;
        return n%2 == 0 ? y*y : y*y*x ;
    }

}
