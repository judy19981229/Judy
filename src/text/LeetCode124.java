package text;

public class LeetCode124 {
    //最大值，初始化为int的最小值
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }
    public int max(TreeNode root){
        //递归终止条件，root为null
        if(root == null) return 0;
        //计算左右子节点的最大路径和(不考虑小于0的情况)
        int left = Math.max(max(root.left), 0);
        int right = Math.max(max(root.right), 0);
        //判断最大路径和(之前的最大值和当前+左+右的最大路径和)
        max = Math.max(max, root.val + left + right);
        //找出左右子节点的最大路径和中较大的那个，加上当前节点的值返回
        //当前节点可以连续的最大路径和，只能是左/右+当前节点 不能是左+右+当前节点(这样没法继续向上递归)
        int curMax = Math.max(left, right);
        return root.val + curMax;
    }
}
