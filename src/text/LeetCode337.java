package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode337 {
    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        //特殊情况
        if(root.left == null && root.right == null) return root.val;
        //动态规划数组
        int[] dp = dp(root);
        return Math.max(dp[0], dp[1]);
    }
    //动态规划获取dp数组，dp[0]表示不要当前节点，要它的子节点，dp[1]表示要当前节点，不要它的子节点
    public int[] dp(TreeNode root){
        int[] dp = new int[2];
        //边界条件
        if(root == null) return dp;
        //要左子节点dpLeft[0]，不要左子节点dpLeft[1]
        int[] dpLeft = new int[2];
        //要右子节点dpRight[0],不要右子节点dpRight[1]
        int[] dpRight = new int[2];
        dpLeft = dp(root.left);
        dpRight = dp(root.right);
        //要当前节点,不要左右子节点
        dp[0] = root.val + dpLeft[1] + dpRight[1];
        //不要当前节点，要左右子节点(找dpLeft和dpRight的最大值)
        dp[1] = Math.max(dpLeft[0], dpLeft[1]) + Math.max(dpRight[0], dpRight[1]);
        return dp;
    }
}
