package text;

public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        //特殊情况，s和p相等
        if(s.equals(p)) return true;
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        //动态规划
        //用来存储s的1-i个字符，和p的1-j个字符的匹配结果
        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];
        //c和p全为空，可以匹配
        dp[0][0] = true;
        //如果p为0, s不为0(p为null, s不为null), 一定匹配不上，所以dp[s.length][0]全为false
        //boolean数组的默认值就是false
        //如果s为0, p不为0(s为null, p不为null), 那么只有p为 X* 的时候才能匹配上
        for(int j = 1; j <= cp.length; j++){
            //j从1开始，数组下标从0开始，这里的cp[j - 1]需要进行j - 1操作
            if(cp[j - 1] == '*'){
                //p不可能以*开头，所以这里j - 2不用担心下标溢出问题
                dp[0][j] = dp[0][j - 2];
            }
        }
        //s和p都不为空，开始遍历(分别把s和p从头开始挨个匹配，s的1 - i匹配p的1 - j)
        for(int i = 1; i <= cs.length; i++){
            for(int j = 1; j <=cp.length; j++){
                //如果当前的s的字符和p的字符相等，或者p的字符是. 那么直接看它前一次的匹配结果即可
                //变成s的 1 ~ i - 1个字符和p的1 ~ j - 1个字符的结果
                if(cs[i - 1] == cp[j - 1] || cp[j - 1] == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //如果当前s和p的字符不相等，那么只有p的字符为*的时候有可能相等
                else if(cp[j - 1] == '*'){
                    //如果p的*号前面一个字符和s的当前字符相等，或者*号前面一个字符为.
                    if(cs[i - 1] == cp[j - 2] || cp[j - 2] == '.'){
                        //*号有可能匹配0个/1-多个前面的字符
                        //匹配0个:aa和aa.*/aaa*
                        //匹配0个就变成了s的 1 - i个字符是否和p的1 ~ j - 2个字符匹配了
                        //匹配1个就变成了s的 1 ~ i - 1个字符和p的1 ~ j - 2个字符的结果
                        //匹配多个就变成了s的 1 ~ i - 1个字符和p的1 - j个字符的结果
                        //匹配多个的情况下，我们可以从p的a*中拿出一个a来和s的一个a抵消
                        //所以p的下标j不动，s的下标i往前一个字符到i - 1，
                        //dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                        //这里的匹配1到多个可以直接合并为dp[i - 1][j]
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                    //p的*号前面一个字符和s的当前字符不相等，*号匹配零个前面一个字符
                    else{
                        //这时就要看p的*号前面两个字符1 ~ j - 2是否和s的1 - i匹配了
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        //最终s和p的匹配结果存储在dp[s.length][p.length中]
        return dp[cs.length][cp.length];
    }
}
