package text;

public class LeetCode543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root){
        //递归终止条件
        if(root == null) return 0;
        //左节点深度
        int left = depth(root.left);
        //右节点深度
        int right = depth(root.right);
        //判断最大值，左节点深度+右节点深度
        max = Math.max(max, left + right);
        //返回当前节点最大深度，左节点深度和右节点深度中较大那个，加上根节点到左右子节点的深度1
        return Math.max(left, right) + 1;
    }
}
