package text;

public class LeetCode647 {
    public int countSubstrings(String s) {
        int length = s.length();
        if(length == 1) return 1;
        int count = s.length();
        char[] c = s.toCharArray();
        //遍历回文的中心点(中心点为1个/2个元素，3个元素直接就为回文了)
        for(int i = 0; i <= length - 1; i++){
            //中心点为两个元素(先判断这两个元素是否相等)
            int left = i;
            int right = i + 1;
            while(left >= 0 && right <= length - 1 && c[left] == c[right]){
                left--;
                right++;
                count++;
            }
            //中心点为一个元素(直接判断它两边的元素是否相等)
            left = i - 1;
            right = i + 1;
            while(left >= 0 && right <= length - 1 && c[left] == c[right]){
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
    public int countSubstringsDP(String s) {
        int length = s.length();
        if(length == 1) return 1;
        int count = 0;
        //dp[i][j]表示从i下标位置到j下标位置是否是回文
        boolean[][] dp = new boolean[length][length];
        for(int i = length - 1; i >= 0; i--){
            for(int j = i; j <= length - 1; j++){
                //if(i == j) dp[i][j] = true;
                //只有i、j下标处元素相同时才判断
                if(s.charAt(i) == s.charAt(j)){
                    //j和i位置相同、或者j是i的下一个，直接就是回文
                    if(j - i <= 1){
                        dp[i][j] = true;
                        count++;
                    }
                    //如果i + 1位置到j - 1位置(向里缩)是回文，那么i j位置就是回文
                    else if(dp[i + 1][j - 1] == true){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
