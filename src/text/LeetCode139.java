package text;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public static void main(String[] args) {
        boolean[] dp = new boolean[2];
        dp[0] = true;
        System.out.println("0:"+dp[0]);
        System.out.println("1:"+dp[1]);
        System.out.println("abc".substring(1,2));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        //动态规划，dp[i]表示s的前i个字母能否用字典中的单词拼接
        boolean[] dp = new boolean[length + 1];
        //s为空，不用字典中的单词就能拼出s
        dp[0] =  true;
        //用HashSet来存储字典中的单词，判断字典中单词是否存在的时间复杂度为O(1)
        Set<String> set = new HashSet<>(wordDict);
        //s的前i个字母能否用字典中的单词拼接
        for(int i = 1; i <= length; i++){
            //把s的前i个字母一分为2为，0到j 和 j + 1到i
            //0到j能否用字典中单词拼接为dp[j]
            //j + 1到i直接判断字典中是否存在 s.substring(j, i)为 s的 j + 1 到 i + 1 - 1(左闭右开)
            for(int j = i - 1; j >= 0; j--){
                //如果0到j 和 j + 1到i 都满足，dp[i]为true，跳出当前j的循环
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
