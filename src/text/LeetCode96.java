package text;

public class LeetCode96 {
    //二叉搜索树：左小右大，根结点为i，左边可以有 i - 1种可能，右边可以有n - i种可能
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //空树，为一种情况
        dp[0] =  1;
        //只有一个1，为一种情况
        dp[1] = 1;
        //当前的节点为i，i节点的二叉搜索树的可能性为i左子树的可能性*i右子树的可能性 再依次向下累加
        //f(n)=f(0)*f(n−1)+f(1)*f(n−2)+...+f(n−1)*f(0)
        for(int i = 2; i <= n; i++){
            for(int j =1; j <= i; j++){
                //左边有dp[i - j]种可能，右边有dp[j - 1]种可能
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
