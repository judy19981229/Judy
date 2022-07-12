package text;

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        //动态规划，dp中记录的是word1的前i个字母转成word2的前j个字母的最少操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //word1和word2都为0，那么无需操作
        dp[0][0] = 0;
        //word2为0，word1的前i个字母转成word2的最少操作数为word2的长度
        for(int i = 1; i <= word1.length(); i++) dp[i][0] = i;
        //word1为0，word2的前j个字母转成word1的最少操作数为word1的长度
        for(int j = 1; j <= word2.length(); j++) dp[0][j] = j;
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                //如果word1的第i个字母和word2的第j个字母相同
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    //那么当前最少操作数等于word1的前i - 1个字母转成word2的前j - 1个字母的最少操作数
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //如果word1的第i个字母和word2的第j个字母不相同
                else{
                    //那么就要找
                    //word1的前i - 1个字母转成word2的前j个字母的最少操作数
                    //word1的前i个字母转成word2的前j - 1个字母的最少操作数
                    //word1的前i - 1个字母转成word2的前j - 1个字母的最少操作数
                    //三个值中较小的那个，再加上1（word1的第i个字母转成word2的第j个字母）
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
