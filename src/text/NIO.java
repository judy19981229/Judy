package text;

import java.util.Scanner;

public class NIO {
    /*
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String s = in.next();
        System.out.println(longest(s));

    }
    public static int longest(String s) {
        int length = s.length();
        int count = 0;
        for(int i = 0; i < length; i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
                if(count < 0){
                    return i;
                }
            }
        }
        return s.charAt(length - 1) == ')' ? length : 0;
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        System.out.println(count(n, x1, y1, x2, y2) % 998244353);

    }
    public static int count(int n, int x1, int y1, int x2, int y2) {
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            if(i == x1 || i == x2) break;
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            if(j == y1 || j == y2) break;
            dp[0][j] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if((i == x1 && j == y1) || (i == x2 && j == y2) ){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][n -1];
    }

}
