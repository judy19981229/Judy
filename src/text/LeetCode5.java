package text;

public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println("abcd".substring(0,2));
    }
    public String longestPalindrome(String s) {
        int length = s.length();
        //特殊情况
        if(length < 2) return s;
        //最长回文串的开始下标
        int begin = 0;
        //最长回文串的个数（一个字数肯定是，所以最小值为1）
        int maxLength = 1;
        //动态规划数组，记录dp[i][j]表示从i到j（包含i和j位置）字符串是否为回文串
        boolean[][] dp = new boolean[length][length];
        //先把i和j相同位置赋值为true，一个字符肯定是回文
        for(int i = 0; i < length; i++){
            dp[i][i] = true;
        }
        //从i到j，所以i应该要比j小，先从1开始循环j，再循环i，i的循环条件是i < j
        for(int j = 1; j < length; j++){
            for(int i = 0; i < j; i++){
                //i和j位置字符不相等，一定不是回文串
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{//i和j位置字符相等
                    //如果j和i之间差值小于3（表示i和j中间只有0或1个字符）那么一定是回文串
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        //如果j和i之间字符有2个或以上，那么就要根据i + 1 到 j - 1是不是回文串来判断
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    //判断最长回文串的个数(j - i + 1)
                    if(dp[i][j] && j - i + 1  > maxLength){
                        maxLength = j - i + 1;
                        begin = i;
                    }
                }

            }
        }
        return s.substring(begin, begin + maxLength);
    }

}
