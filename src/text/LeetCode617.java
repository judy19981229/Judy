package text;

public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //如果root1为null，直接拼接root2(如果root1和root2都为null都话也会返回null)
        if(root1 == null) return root2;
        //如果root2为null，直接拼接root1
        if(root2 == null) return root1;
        //合并节点的值是root1的值 + root2的值
        TreeNode merge = new TreeNode(root1.val + root2.val);
        //合并左子节点
        merge.left = mergeTrees(root1.left, root2.left);
        //合并右子节点
        merge.right = mergeTrees(root1.right, root2.right);
        //返回合并节点
        return merge;
    }
}
